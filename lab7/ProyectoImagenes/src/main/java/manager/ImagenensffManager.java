package manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Imagenensff;

public class ImagenensffManager {

private EntityManagerFactory emf;
	
	public ImagenensffManager(String unidadDePersistencia)
	{
		emf = Persistence.createEntityManagerFactory(unidadDePersistencia);
	}
	
	public ImagenensffManager(EntityManagerFactory factory)
	{
		emf = factory;
	}
	
	
	public String create(Imagenensff imagen)  {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(imagen);
			em.getTransaction().commit();
		} catch (Exception ex) {
			try {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			em.close();
		}
		return "";
	}
	
	// Esta anotación es para quitar el warning avisandonos que es está
	// haciendo una conversión de List a List<Imagenenbbdd> y puede no ser válida
	@SuppressWarnings("unchecked")
	public List<Imagenensff> findAll() {
		List<Imagenensff> resultado;
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createNamedQuery("Imagenensff.findAll",Imagenensff.class);
			resultado = query.getResultList();
		} finally {
			em.close();
		}
		return resultado;

	}
	
	@SuppressWarnings("unchecked")
	public List<Imagenensff> findBySimilarTitle(String  titulo) {
		List<Imagenensff> resultado;
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createNamedQuery("Imagenensff.findBySimilarTitle",Imagenensff.class);
			// Atención: Se neceista agregar el % porque se usa una consutla con like (buscar en google)
			query.setParameter("titulo","%"+titulo+"%");
			resultado = query.getResultList();
		} finally {
			em.close();
		}
		return resultado;

	}
	
	public Imagenensff findById(int id) {
		Imagenensff resultado;
		EntityManager em = emf.createEntityManager();
		try {
			resultado  = em.find(Imagenensff.class, id);
		} finally {
			em.close();
		}
		return resultado;
	}
}
