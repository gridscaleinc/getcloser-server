class TheWorld {
    constructor() {
        this._scene = new THREE.Scene();
        this._camera = undefined;
    }

    get camera() {
        return this._camera;
    }

    set camera(c) {
        this._camera = c;
    }

    get scene() {
        return this._scene;
    }

    set scene(s) {
        this._scene = s;
    }

}

function initializeDataStore () {
    return {};
}

var GetCloserApp = {

    dataStore: this.initializeDataStore(),

    // Three JS のすべて
    theWorld: new TheWorld(),

}


class TextBoardParam {
    constructor (color, font) {
        this.font = "120px Arial";
        this.fillStyle  = "rgba(255,255,255,0.95)";

        if (color) {
            this.fillStyle = color;
        }

        if (font) {
            this.font
        }
    }

}

class TextBoard {
    constructor(parameter) {
        parameter = parameter || new TextBoardParam();
        this.parameter = parameter;
    }

    createPlane (text) {


        // create a canvas element
        var canvas = document.createElement('canvas');
        var context1 = canvas.getContext('2d');
        context1.font = this.parameter.font;
        context1.fillStyle = this.parameter.fillStyle;

        var width = context1.measureText(text).width
        canvas.width = width;
        canvas.height = 130;
        context1.font = this.parameter.font;
        context1.fillStyle = this.parameter.fillStyle;

        context1.fillText(text, 0, 90);

        this.texture = new THREE.Texture(canvas);
        this.texture.needsUpdate = true;

        let ratio = canvas.width / canvas.height;

        var geometry = new THREE.PlaneGeometry(10*ratio, 10);
        var material = new THREE.MeshStandardMaterial({ map: this.texture,
            emissive: 0xffffff,
            side: THREE.DoubleSide });
        material.transparent = true;
        material.depthWrite = false;

        this.plane = new THREE.Mesh(geometry, material);
        // document.removeChild(canvas);

        return this.plane;
    }

}



function createMesh(geom) {

    // assign two materials
    //            var meshMaterial = new THREE.MeshLambertMaterial({color: 0xff5555});
    //            var meshMaterial = new THREE.MeshNormalMaterial();
    var meshMaterial = new THREE.MeshPhongMaterial({
        specular: 0xffffff,
        color: 0xff6666,
        shininess: 100
    });
    //            meshMaterial.side=THREE.DoubleSide;
    // create a multimaterial
    return new THREE.Mesh(geom, meshMaterial);
}

function createText (text) {
            var fontloader = new THREE.FontLoader();

        fontloader.load( '/fonts/helvetiker_regular.typeface.json', function ( font ) {

            var geometry = new THREE.TextGeometry( text, {
                font: font,
                size: 80,
                height: 15,
                curveSegments: 40,
                bevelEnabled: true,
                bevelThickness: 10,
                bevelSize: 8,
                bevelOffset: 1,
                bevelSegments: 8
            } );

            var m = createMesh(geometry);
            scene.add(m);


        } );
}


