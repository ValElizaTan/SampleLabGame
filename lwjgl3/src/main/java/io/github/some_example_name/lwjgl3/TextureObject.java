package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextureObject extends Entity {
	private Texture tex;

	public TextureObject() {

	}

	public TextureObject(String s, float x, float y, float speed) {

		this.x = x;
		this.y = y;
		this.speed = speed;

	}

	public Texture getTexture() {

		return tex;
	}

	void setTexture(Texture t) {
		tex = t;
	}

	public void resetPosition() {
		this.y = 400;
		this.x = (float) Math.random() * (800 - this.getTexture().getWidth());
		this.speed += 0.5f;
		if (this.speed > 10) {
			this.speed = 10;
		}
	}

	public void updatePosition(boolean isLeft) {
		if (isLeft) {
			this.x -= 200 * Gdx.graphics.getDeltaTime();
			if (this.x > 800 - this.getTexture().getWidth())
				this.x = 800 - this.getTexture().getWidth();
		}
	}

//	public void movement() {
//		setY(getY() - getSpeed());
//		if (getY() < 0) {
//			setY(400); // Reset position
//			setX((float) Math.random() * (800 - tex.getWidth()));
//		}
//	}

	@Override
	public void draw(SpriteBatch batch) {
		if (tex != null) {
			batch.draw(tex, getX(), getY());
		}
	}

	@Override
	public void moveUserControlled() {

	}

	@Override
	public void moveAIControlled() {
		this.y -= this.speed;
		if (this.y < 0) {
			resetPosition();
		}
	}

	@Override
	public void update() {
		if (tex != null) {
			System.out.println("In textureObject of " + tex.toString() + " at " + x + ", " + y + " position");
		}
	}

	public void dispose() {

	}

}