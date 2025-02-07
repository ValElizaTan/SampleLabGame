package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Triangle extends Entity {

	float x1, x2, y1, y2, x3, y3;
	public Color color;

	public Triangle() {
	}

	public Triangle(float x, float y, Color c, float speed) {

		super(x, y, speed);
		this.color = c;

	}

	public Color getColor() {

		return color;
	}

	public void setColor(Color c) {
		color = c;
	}

	public void draw(ShapeRenderer shape) {
		shape.setColor(getColor());
		float size = 50;

		float x1 = x - size;
		float y1 = y - size;

		float x2 = x + size;
		float y2 = y - size;

		float x3 = x;
		float y3 = y + size;

		shape.triangle(x1, y1, x2, y2, x3, y3);
	}

	public void moveUserControlled() {
		if (Gdx.input.isKeyPressed(Keys.A)) { // Left
			move(-1, 0);
		}

		if (Gdx.input.isKeyPressed(Keys.D)) { // Right
			move(1, 0);
		}
	}

	public void moveAIControlled() {

	}

	@Override
	public void update() {
		System.out.println("In triangle at " + x + ", " + y + " position");
	}

}
