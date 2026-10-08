import processing.core.PApplet;

class Wave {
    PApplet p;
    float x, y;

    Wave(PApplet p, float x, float y) {
        this.p = p;
        this.x = x;
        this.y = y;
    }

    void display() {
        p.stroke(255);
        p.noFill();
        p.ellipse(x, y, 50, 50);
    }
}

public class Main extends PApplet {
    float[] angles;
    float circlesRadius = 10f;
    Wave localWave;
    float angleStep = 0.05f;
    float angleOffset = 0.2f;
    public void settings() {
        size(600, 400);
    }


    public void setup() {
        localWave = new Wave(this, width / 2f, height / 2f);

        int total = floor(width / (circlesRadius * 2));
        angles = new float[total];

        for (int i = 0; i < total; ++i) {
            angles[i] = i * angleOffset;
        }
    }

    public void draw() {
        background(30);

        localWave.display();

        pushMatrix();
        translate(300, 200);
        fill(252, 238, 33);
        stroke(252, 238, 33);

        for (int i = 0; i < angles.length; ++i) {
            float y = map(sin(angles[i]), -1, 1, -150, 150);
            float x = map(i, 0, angles.length, -200, 200);
            strokeWeight(2);
            line(x, 0, x, y);
            circle(x, y, circlesRadius * 2);
            angles[i] += angleStep;
        }
        popMatrix();
    }    public static void main(String[] args) {
        PApplet.main("Main");
    }
}