var stompClient = null;
var ws_connected = false;

function setConnected(connected) {
    ws_connected = connected;
}

function connect(onMessage) {
    var socket = new SockJS('/endpoint-getcloser');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        ws_connected = true;
        stompClient.subscribe('/app/geotag/1', function (greeting) {
            var content = JSON.parse(greeting.body).content;
            onMessage(content);
        });
    });
}

function sendMessage(message) {
    stompClient.send("/app/hello", {}, JSON.stringify({ 'name': message }));
}

var location1 = {
    startup: function () {
        var scene;
        var sphereEarth; // 追加
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
        scene.fog = new THREE.FogExp2( 0x248bff, 0.00025 );

        loader = new THREE.TextureLoader();

        // 追加：宇宙テクスチャーを準備
        loader.load('/images/texture/galaxy_starfield.png', function(texture) {
        	createUniverse(texture);
            render();
        });

        var app = new Vue({
            el: '#chatbox',
            data: {
                message: 'Hello Vue!',
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

            var targetPosition = new THREE.Vector3(targetX, targetY, 0.57);
            targetPosition.unproject(camera);

            // var direction = targetPosition.sub(camera.position).normalize();
            // var distance =  -camera.position.z / direction.z;
            // var scaled = direction.multiplyScalar(distance);
            // var targetWorldCoord = camera.position.clone().add(scaled);


            var plane = new TextBoard().createPlane(text);
            plane.lookAt(camera.position);
            plane.position.set((Math.random() - 0.5) * 2 * Math.floor(500) + 200, Math.random() * Math.floor(200), -250);
            scene.add(plane);
            // mark(targetPosition);

            var stopflag = false;
            var tween = new TWEEN.Tween(plane.position)
                .to(targetPosition, 4000)
                .onUpdate(function () {
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

        //olympic-rings-png-clip-art.png


        // 追加：地球を作る
        function createEarth() {
            var material = new THREE.MeshStandardMaterial({wireframe:false});
            sphereEarth = new THREE.Object3D();
            var e = new THREE.Mesh(
                new THREE.PlaneGeometry(40000,40000, 100, 100) // 形状
                , material
            );
            sphereEarth.add(e);
            sphereEarth.position.set(0, 0, 0);
            scene.add(sphereEarth);
            e.rotation.x = -Math.PI/2.05;

            // 追加：地球テクスチャーを準備
            var texture = new THREE.TextureLoader().load('/images/texture/green-grass-85.png');
            // var texture = new THREE.TextureLoader().load('/images/texture/plain_w.jpg');

            texture.wrapS = texture.wrapT = THREE.RepeatWrapping;
            texture.offset.set( 0, 0 );
            texture.repeat.set( 1600, 1600 );
            material.map = texture;

            var material1 = new THREE.MeshStandardMaterial({wireframe:false});
            var o = new THREE.Mesh(
                new THREE.PlaneGeometry(4000,4000, 100, 100) // 形状
                , material1
            );
            sphereEarth.add(o);

            var texture1 = new THREE.TextureLoader().load('/images/texture/olympic-rings-png-clip-art.png');
            material1.map = texture1;
            material1.transparent= true;
            material1.opacity = 0.5;
            o.rotation.x = -Math.PI/2.05;
            o.position.y = 10;

        };

        // 追加：宇宙を作る
        function createUniverse(texture) {
            texture.wrapS = texture.wrapT = THREE.RepeatWrapping;
            texture.offset.set( 0, 0 );
            texture.repeat.set( 18, 18 );

            sphereUniverse = new THREE.Mesh(
                new THREE.SphereGeometry(90000, 80, 80), // 形状
                new THREE.MeshLambertMaterial({ // 材質
                    map: texture,
                    side: THREE.DoubleSide // 裏からも見えるようにする
                })
            );
            sphereUniverse.position.set(0, 0, 0);
            scene.add(sphereUniverse);
        };


        createEarth();

        // 追加：点光源を作る
        light = new THREE.PointLight(0xFFD400, 2.5, 0);
        light.position.set(100, 130, 100000);
        scene.add(light);


        // spotlight #2 -- red, light shadow
        var spotlight2 = new THREE.SpotLight(0xff0000);
        spotlight2.position.set(-2060,5500,-60);
        scene.add(spotlight2);

    	// spotlight #3
        var spotlight3 = new THREE.SpotLight(0x0000ff);
        spotlight3.position.set(1150,5580,-100);
        scene.add(spotlight3);


        // 環境光を作る
        ambient = new THREE.AmbientLight(0xFFff00, 1.0);
        scene.add(ambient);

        // カメラを作る
        camera = new THREE.PerspectiveCamera(30, width / height, 1, 100000);

        camera.position.set(0, 0, 1100);

        camera.lookAt(new THREE.Vector3(0,10000,-100));

        // helper
        // gridHelper = new THREE.GridHelper(200, 20);
        // scene.add(gridHelper);
        // axisHelper = new THREE.AxisHelper(1000);
        // scene.add(axisHelper);
        // lightHelper = new THREE.PointLightHelper(light, 20);
        // scene.add(lightHelper);

        // controls
        controls = new THREE.OrbitControls(camera, document.getElementById('stage'));
        controls.enableRotate = true;
        controls.minDistance = 1;
        controls.maxDistance = 5000;
        controls.minPolarAngle = 1.4;
        controls.maxPolarAngle = 1.7;
        controls.rotateSpeed = 0.05;


        // renderer
        renderer = new THREE.WebGLRenderer({ antialias: true });
        renderer.setSize(width, height);
        renderer.setClearColor(0x0000ff);
        renderer.setPixelRatio(window.devicePixelRatio);
        document.getElementById('stage').appendChild(renderer.domElement);

        var started = true;
        var t = 0;
        step = 0.4;
        animateTImes = 1000;
        function render() {
            if (t < animateTImes) {
                // if (started) {
                //     sphereEarth.position.z += step;
                // }
                requestAnimationFrame(render);
                t++;
            } else {
                started = false;
                step = 0;
            }

            // sphereEarth.rotation.y = sphereEarth.rotation.y + 0.015; // 追加：地球を回転させる
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



        render();


    }
}
