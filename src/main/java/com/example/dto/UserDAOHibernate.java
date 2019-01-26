package com.example.dto;

import org.hibernate.Session;
import com.example.model.User;
import java.util.ArrayList;


public class UserDAOHibernate {
	private Session s = null;

    // Renvoie l'utilisateur possédant le login passé en paramètre
    public User getFromLogin(String login) {
          // Voir implémentation au chapitre « Gestion des utilisateurs »
    	return null;
    }

    // Enregistre dans la base de données l'entité passée en paramètre
    public User makePersistent(User entity) {           
          // Voir implémentation au chapitre « Gestion des utilisateurs »
    	return null;
    }

    // Renvoie l'utilisateur possédant le login et le mot de passe passés en paramètres
    public User getFromLoginPassword(String login, String password) {
          // Voir implémentation au chapitre « Gestion des utilisateurs »
    	return null;
    }

    // Renvoie l'UserDTO créé à partir du User passé en paramètre
	public static UserDto createDTO(User u) {
		UserDto uDTO = new UserDto();
		uDTO.setId(u.getUserId());
		uDTO.setEmail(u.getEmail());
		uDTO.setFirstname(u.getFirstname());
		uDTO.setLastname(u.getLastname());
		return uDTO;
	}
	
	// Renvoie l'User créé à partir du UserDTO passé en paramètre
    public User createBean(UserDto uDTO) {
          User u = new User();

          // Recopie des attributs "simples"
          u.setUserId(uDTO.getId());
          u.setEmail(uDTO.getEmail());
          u.setFirstname(uDTO.getFirstname());
          u.setLastname(uDTO.getLastname());

          return u;
    }

}
