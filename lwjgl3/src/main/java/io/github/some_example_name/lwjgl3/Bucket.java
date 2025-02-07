package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Bucket extends TextureObject {

	public Bucket() {

	}

	public Bucket(String s) {

	}

	public Bucket(String s, float x, float y, float speed) {
	}

	@Override
	public void moveUserControlled() {
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			this.x -= 200 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			this.x += 200 * Gdx.graphics.getDeltaTime();
		}
	}

	@Override
	public void update() {
		System.out.println("Bucket at " + x + ", " + y);
	}
}
