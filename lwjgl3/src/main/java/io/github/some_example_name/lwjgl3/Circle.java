package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Circle extends Entity {

	float radius;
	private Color color;

	public Circle() {

		this.radius = 0;

	}

	public Circle(float r, float x, float y, Color c, float speed) {

		super(x, y, speed);
		this.radius = r;
		this.color = c;

	}

	public float getRadius() {

		return radius;
	}

	void setRadius(float r) {
		radius = r;
	}

	public Color getColor() {

		return color;
	}

	public void setColor(Color c) {
		color = c;
	}

	public void draw(ShapeRenderer shape) {
		if (shape != null) {
			shape.setColor(getColor());
			shape.circle(getX(), getY(), getRadius()); // Ensure it uses correct radius
		}
	}

	public void moveUserControlled() {
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			move(0, 1);
		}

		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			move(0, -1);
		}
	}

	public void moveAIControlled() {

	}

	@Override
	public void update() {
		System.out.println("In circle of radius " + radius + " at " + x + ", " + y + " position");
	}

}
