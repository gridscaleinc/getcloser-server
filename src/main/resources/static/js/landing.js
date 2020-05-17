var stompClient = null;
var ws_connected = false;

function setConnected(connected) {
    ws_connected = connected;
}

function connect(onMessage) {
    var socket = new WebSocket('ws://localhost:8080/endpoint-getcloser');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        ws_connected = true;
        stompClient.subscribe('/app/geotag/1', function (greeting) {
        	console.log("greeting:", greeting);
            var content = greeting.body;
            onMessage(content);
        });
    });
}

function sendMessage(message) {
    stompClient.send("/app/hello", {}, message);
}

var landing = {
    startup: function () {
        var scene;
        var sphereEarth; // 追加
        var sphereCrowd; // 追加
        var sphereUniverse; // 追加
        var camera;
        var light;
        var ambient;
        var gridHelper;
        var axisHelper;
        var lightHelper;
        var renderer;
        var loader;
        var width = window.innerWidth;
        var height = window.innerHeight;
        var controls;

        // document.body.requestFullscreen();

        // ステージを作る
        scene = new THREE.Scene();
        window.scene = scene;
        // scene.fog = new THREE.Fog(0x111111, 1200, 2000);

        loader = new THREE.TextureLoader();

        // 追加：雲テクスチャーを準備
        loader.load('/images/texture/earthcloudmap.jpg', function (texture) {
            createCrowd(texture);
        });

        // 追加：宇宙テクスチャーを準備
        loader.load('/images/texture/galaxy_starfield.png', function(texture) {
        	createUniverse(texture);
            render();
        });


        var app = new Vue({
            el: '#chatbox',
            data: {
                message: 'Hello World!',
                talks: [

                ]
            }
            ,
            mounted: function () {
                connect(this.receiveMessage);
            }

            , methods: {
                send: function () {
                    if (ws_connected) {
                        sendMessage(this.message);
                        // this.message = "";
                    }
                },
                receiveMessage: function (msg) {
                    this.talks.push({ id: '100', text: msg });
                    animateText(msg);
                    if (this.talks.length > 20) {
                        this.talks = this.talks.slice(1);
                    }
                    // var container = this.$el.querySelector("#chatbox");
                    // container.scrollTop = container.scrollHeight;
                }

            }

        });

        function mark(p, color) {
            var geometry = new THREE.PlaneGeometry(2, 2, 1);
            var material = new THREE.MeshBasicMaterial({ color:color, side: THREE.DoubleSide });
            var pl = new THREE.Mesh(geometry, material);
            pl.position.set(p.x, p.y, p.z);
            scene.add(pl);
        }

        function animateText(text) {

            targetX = 1.0 * 2.0 - 1.0;
            targetY = -1.0 * 2.0 + 1.0;

            var targetPosition = new THREE.Vector3(targetX, targetY, -0.97);
            targetPosition.unproject(camera);

            // var direction = targetPosition.sub(camera.position).normalize();
            // var distance =  -camera.position.z / direction.z;
            // var scaled = direction.multiplyScalar(distance);
            // var targetWorldCoord = camera.position.clone().add(scaled);


            var plane = new TextBoard().createPlane(text);
            plane.lookAt(camera.position);
            plane.position.set((Math.random() - 0.5) * 2 * Math.floor(400), (Math.random() - 0.5) * 2 * Math.floor(400), -250);
            scene.add(plane);
            // mark(targetPosition);

            var stopflag = false;
            var tween = new TWEEN.Tween(plane.position)
                .to(targetPosition, 3500)
                .onUpdate(function () {
                    console.log(plane.position);
                }).onComplete(
                    function () {
                        stopflag = true;
                        scene.remove(plane);
                    }
                )
                .start();

            function animateThis() {
                TWEEN.update();
                if (!stopflag) {
                    requestAnimationFrame(animateThis);
                }
                renderer.render(scene, camera);
            }

            requestAnimationFrame(animateThis);

        }


        // 追加：地球を作る
        function createEarth() {
            var material = new THREE.MeshStandardMaterial();
            sphereEarth = new THREE.Object3D();
            var e = new THREE.Mesh(
                new THREE.SphereGeometry(100, 100, 100) // 形状
                , material
            );
            sphereEarth.add(e);
            sphereEarth.position.set(0, 0, -550);
            scene.add(sphereEarth);

            // 追加：地球テクスチャーを準備
            var texture = new THREE.TextureLoader().load('/images/texture/earthlights1k.jpg');
            material.map = texture;


            // var texture1 = new THREE.TextureLoader().load('/images/texture/earthlights1k.jpg');
            // material.emissiveMap = texture1;
            // material.shiness = 0.9;


        };

        // 追加：雲を作る
        function createCrowd(texture) {
            sphereCrowd = new THREE.Mesh(
                new THREE.SphereGeometry(105, 50, 50), // 形状
                new THREE.MeshLambertMaterial({ // 材質
                    map: texture,
                    transparent: true,
                    opacity: 0.8,
                    side: THREE.DoubleSide // 裏からも見えるようにする
                })
            );
            sphereCrowd.position.set(0, 0, -550);
            scene.add(sphereCrowd);
        };

        // 追加：宇宙を作る
        function createUniverse(texture) {
            texture.wrapS = texture.wrapT = THREE.RepeatWrapping;
            texture.offset.set( 0, 0 );
            texture.repeat.set( 18, 18 );

            sphereUniverse = new THREE.Mesh(
                new THREE.SphereGeometry(9000, 80, 80), // 形状
                new THREE.MeshLambertMaterial({ // 材質
                    map: texture,
                    side: THREE.DoubleSide // 裏からも見えるようにする
                })
            );
            sphereUniverse.position.set(0, 0, 0);
            scene.add(sphereUniverse);
        };


        createEarth();

        // THREE.CylinderGeometry(上面円の半径, 下面円の半径, 高さ, 縦分割数, 横分割数, 上下面を無くすか否か)
        var cylinderGeometry = new THREE.CylinderGeometry(
            0.5,
            1,
            1000,
            10,
            10,
            true
        );

        const texture1 = new THREE.TextureLoader().load('/images/texture/light.jpg');
        const material1 = new THREE.MeshBasicMaterial({
            map: texture1, // テクスチャーを指定
            color: 0x007eff, // 色
            transparent: true, // 透明の表示許可
            blending: THREE.AdditiveBlending, // ブレンドモード
            side: THREE.DoubleSide, // 表裏の表示設定
            depthWrite: false // デプスバッファへの書き込み可否
        });


        // 光る柱のメッシュを作成
        var mesh = new THREE.Mesh(cylinderGeometry, material1);
        var mesh2 = new THREE.Mesh(cylinderGeometry, material1);

        // mesh.rotation.z = 90 * Math.PI / 180; // 90度回転
        mesh2.rotation.x = 90 * Math.PI / 180; // 90度回転
        // mesh.position.set(-500,0,0);
        mesh2.position.set(0, 0, 500);
        sphereEarth.quaternion

        var q = new THREE.Quaternion();
        q.setFromAxisAngle(new THREE.Vector3(1, 0, 1).normalize(), Math.PI / 4);
        var targetQ = mesh.quaternion;
        targetQ.multiply(q);

        mesh.translateY(500);

        sphereEarth.add(mesh);
        sphereEarth.add(mesh2);


        var logo1 = new TextBoard(new TextBoardParam("rgba(255,100,0,0.95)","120px Arial")).createPlane("Presented");
        logo1.position.set(-10, 0, -450);
        scene.add(logo1);
        logo1.rotation.y = Math.PI/3;
        logo1.rotation.x = -Math.PI/25;

        var logo2 = new TextBoard(new TextBoardParam("rgba(255,100,0,0.95)","120px Arial")).createPlane("By");
        logo2.position.set(20, 0, -450);
        scene.add(logo2);
        logo2.rotation.y = Math.PI/3;
        logo2.rotation.x = -Math.PI/25

        var logo3 = new TextBoard(new TextBoardParam("rgba(255,100,0,0.95)","120px Arial")).createPlane("Gridscale.com");
        logo3.position.set(60 , 0, -450);
        scene.add(logo3);
        logo3.rotation.y = Math.PI/3;
        logo3.rotation.x = -Math.PI/25

        var ray = new THREE.Ray();
        ray.lookAt(mesh.position);

        // 追加：点光源を作る
        light = new THREE.PointLight(0xFFFFFF, 2.5, 0);
        light.position.set(100, 130, 1580);
        scene.add(light);

        // 環境光を作る
        ambient = new THREE.AmbientLight(0x222222);
        scene.add(ambient);

        // カメラを作る
        camera = new THREE.PerspectiveCamera(30, width / height, 10, 11000);

        camera.position.set(30, 30, 1300);

        camera.lookAt(scene.position);

        // helper
        // gridHelper = new THREE.GridHelper(200, 20);
        // scene.add(gridHelper);
        // axisHelper = new THREE.AxisHelper(1000);
        // scene.add(axisHelper);
        // lightHelper = new THREE.PointLightHelper(light, 20);
        // scene.add(lightHelper);

        // controls
        controls = new THREE.OrbitControls(camera, document.getElementById('stage'));

        // renderer
        renderer = new THREE.WebGLRenderer({ antialias: true });
        renderer.setSize(width, height);
        renderer.setClearColor(0x111122);
        renderer.setPixelRatio(window.devicePixelRatio);
        document.getElementById('stage').appendChild(renderer.domElement);

        var started = true;
        var t = 0;
        step = 0.4;
        animateTImes = 1000;
        function render() {
            if (t < animateTImes) {
                if (started) {
                    sphereEarth.position.z += step;
                }
                requestAnimationFrame(render);
                t++;
            } else {
                started = false;
                step = 0;
            }

            sphereEarth.rotation.y = sphereEarth.rotation.y + 0.015; // 追加：地球を回転させる
            if (sphereCrowd != undefined) {
                sphereCrowd.position.z += step;
                sphereCrowd.rotation.y = sphereCrowd.rotation.y + 0.015; // 追加：雲を回転させる
            }
            controls.update();
            renderer.render(scene, camera);
            TWEEN.update();
        }

        // mousedown
        function onMouseDown(event) {
            event.preventDefault();
            if (t < animateTImes) return;

            started = !started;

            if (started) {
                t = 0;
                render();
            } else {
                t = animateTImes;
            }
        }


        renderer.domElement.addEventListener('mousedown', onMouseDown, false);
        window.onresize = function () {
            // サイズを取得
            const width = window.innerWidth;
            const height = window.innerHeight;

            // レンダラーのサイズを調整する
            renderer.setPixelRatio(window.devicePixelRatio);
            renderer.setSize(width, height);

            // カメラのアスペクト比を正す
            camera.aspect = width / height;
            camera.updateProjectionMatrix();
        };

        // var helper = new THREE.CameraHelper( camera );
        // scene.add( helper );

        controls.addEventListener('change', function () {
          renderer.render(scene, camera)
        });



        var tween = new TWEEN.Tween(logo2.position)
            .to(new THREE.Vector3(20, 0, 1050), 1500)
            .onUpdate(function () {
                logo1.position.z = logo2.position.z;
                logo3.position.z = logo2.position.z;
            })
            .start();

        render();


    }
}
