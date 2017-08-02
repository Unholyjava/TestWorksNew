package home.training.HolidaysTest.dao;

import java.util.Collection;

/**
 * Интерфейс, общий для обеих, используемых в программе, сущностей.
 * Имеет один метод getAll(), предполагается, что для использования
 * уже имеющихся данных необходимо предоставить программе список 
 * (коллекцию) этих данных.
 * 
 */
public interface DAO<T> {
	Collection<T> getAll();
}
