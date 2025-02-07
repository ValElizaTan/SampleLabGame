package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameMaster extends ApplicationAdapter { // extends = inheritance

	private Texture dropImage;
	private Texture bucketImage;

	private SpriteBatch batch;
	private ShapeRenderer shape;
	private Entity bucket, circle, triangle;
	private EntityManager droplets;
	private EntityManager em;

	@Override
	public void create() {
		dropImage = new Texture(Gdx.files.internal("droplet.png"));
		bucketImage = new Texture(Gdx.files.internal("bucket.png"));

		batch = new SpriteBatch();
		shape = new ShapeRenderer();
		em = new EntityManager();
		droplets = new EntityManager();

		// Instantiate and add Bucket
		bucket = new Bucket("bucket.png", 368, 20, 0);
		((TextureObject) bucket).setTexture(bucketImage);
		em.add(bucket);

		for (int i = 0; i < 1; i++) {
			Entity drop = new Drop("droplet.png", (float) Math.random() * (800 - dropImage.getWidth()),
					400 + (float) Math.random() * 200, 2 + (float) Math.random() * 2);
			((TextureObject) drop).setTexture(dropImage);
			droplets.add(drop);
		}

		// Instantiate and add Circle and Triangle
		circle = new Circle(50, 500, 300, Color.RED, 200);
		triangle = new Triangle(400, 65, Color.GREEN, 200);
		em.add(circle);
		em.add(triangle);
	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0.2f, 1);

		em.update();
		droplets.update();

		droplets.moveAIControlled();

		// Move user-controlled entities
		bucket.moveUserControlled();
		circle.moveUserControlled();
		triangle.moveUserControlled();

		// Drawing all entities using batch
		batch.begin();
		bucket.draw(batch);
		droplets.draw(batch);
		batch.end();

		shape.begin(ShapeRenderer.ShapeType.Filled);
		circle.draw(shape);
		triangle.draw(shape);
		shape.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		dropImage.dispose();
		bucketImage.dispose();
		shape.dispose();
	}
}
