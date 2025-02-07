package io.github.some_example_name.lwjgl3;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class EntityManager {

	private List<Entity> entityList;

	public EntityManager() {
		entityList = new ArrayList<>();
	}

	public void add(Entity entity) {
		entityList.add(entity);
	}

	public void remove(int index) {
		if (index >= 0 && index < entityList.size()) {
			entityList.remove(index);
		}
	}

	public Entity get(int index) {
		if (index >= 0 && index < entityList.size()) {
			entityList.get(index);
		}

		return null;
	}

	public void draw(SpriteBatch batch) {
		for (Entity entity : entityList) {
			entity.draw(batch);
		}
	}

	public void draw(ShapeRenderer shape) {
		for (Entity entity : entityList) {
			entity.draw(shape);
		}
	}

	public void moveAIControlled() {
		for (Entity entity : entityList) {
			entity.moveAIControlled();
		}
	}

	public void update() {
		for (Entity entity : entityList) {
			entity.update();
		}
	}

}