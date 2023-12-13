/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import com.controller.exceptions.NonexistentEntityException;
import com.models.Incidentes;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author toni
 */
public class IncidentesJpaController implements Serializable {

    public IncidentesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    public IncidentesJpaController() {
        emf = Persistence.createEntityManagerFactory("TrabajoIntegradorJPAPU");
    } 
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Incidentes incidentes) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(incidentes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Incidentes incidentes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            incidentes = em.merge(incidentes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = incidentes.getIdIncidente();
                if (findIncidentes(id) == null) {
                    throw new NonexistentEntityException("The incidentes with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Incidentes incidentes;
            try {
                incidentes = em.getReference(Incidentes.class, id);
                incidentes.getIdIncidente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The incidentes with id " + id + " no longer exists.", enfe);
            }
            em.remove(incidentes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Incidentes> findIncidentesEntities() {
        return findIncidentesEntities(true, -1, -1);
    }

    public List<Incidentes> findIncidentesEntities(int maxResults, int firstResult) {
        return findIncidentesEntities(false, maxResults, firstResult);
    }

    private List<Incidentes> findIncidentesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Incidentes.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Incidentes findIncidentes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Incidentes.class, id);
        } finally {
            em.close();
        }
    }

    public int getIncidentesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Incidentes> rt = cq.from(Incidentes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
