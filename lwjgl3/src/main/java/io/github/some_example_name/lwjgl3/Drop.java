package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.Gdx;

public class Drop extends TextureObject {

	public Drop() {

	}

	public Drop(String s) {

	}

	public Drop(String s, float x, float y, float speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
	}

	@Override
	public void moveAIControlled() {
		float speedMultiplier = 200;
		this.y -= this.speed * speedMultiplier * Gdx.graphics.getDeltaTime();

		if (this.y < 0) {
			resetPosition();
		}
	}

	@Override
	public void update() {
		System.out.println("In textureObject of " + getTexture().toString() + " at 50,50 position");
	}
}