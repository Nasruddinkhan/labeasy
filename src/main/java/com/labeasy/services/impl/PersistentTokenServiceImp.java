package com.labeasy.services.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.entity.PersistentLogins;

@Repository("persistentTokenRepository")
@Transactional
public class PersistentTokenServiceImp implements PersistentTokenRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		PersistentLogins logins = new PersistentLogins();
		logins.setUsername(token.getUsername());
		logins.setSeries(token.getSeries());
		logins.setToken(token.getTokenValue());
		logins.setLastUsed(token.getDate());
		em.persist(logins);
	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		PersistentLogins logins = em.find(PersistentLogins.class, seriesId);
		if (logins != null) {
			return new PersistentRememberMeToken(logins.getUsername(), logins.getSeries(), logins.getToken(),
					logins.getLastUsed());
		}
		return null;
	}

	@Override
	public void removeUserTokens(String username) {
		em.createQuery("delete from PersistentLogins" + " where username=:userName")
				.setParameter("userName", username).executeUpdate();
	}

	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) {
		PersistentLogins logins = em.find(PersistentLogins.class, series);
		logins.setToken(tokenValue);
		logins.setLastUsed(lastUsed);
	}

}
