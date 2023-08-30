package Hibernate;

import java.util.List;

import org.junit.Test;

import DAO.DAOGeneric;
import model.UsuarioPessoa;

public class teste {
	
	@Test
	public void testeHibernate() {
		DAOGeneric<UsuarioPessoa> daoGeneric = new DAOGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();

		try {
			pessoa.setIdade(22);
			pessoa.setLogin("Bruna");
			pessoa.setNome("Bruna");
			pessoa.setSobrenome("Gomes");
			pessoa.setSenha("1234");
			pessoa.setEmail("Bruna@gmail.com");

			daoGeneric.salvar(pessoa);
			
		} catch (Exception e) {
			// Ignora o erro e não faz nada
		}
	}

	@Test
	public void testeBusca() {
		try {
			DAOGeneric<UsuarioPessoa> daoGeneric = new DAOGeneric<UsuarioPessoa>();
			UsuarioPessoa pessoa = new UsuarioPessoa();
			pessoa.setId(2L);
			
			pessoa = daoGeneric.pesquisar(pessoa);
			
			System.out.println(pessoa);
			
        } catch(Exception e) {
            // Ignora o erro e não faz nada
        }
	}
	
	@Test
	public void testeBusca2() {
		try {
			DAOGeneric<UsuarioPessoa> daoGeneric = new DAOGeneric<UsuarioPessoa>();

			UsuarioPessoa pessoa = daoGeneric.pesquisar(10L, UsuarioPessoa.class);
			
			System.out.println(pessoa);
			
        } catch(Exception e) {
            // Ignora o erro e não faz nada
        }
	}
	
	@Test
	public void testeUpdate() {
		try {
			DAOGeneric<UsuarioPessoa> daoGeneric = new DAOGeneric<UsuarioPessoa>();

			UsuarioPessoa pessoa = daoGeneric.pesquisar(10L, UsuarioPessoa.class);
			
			pessoa.setIdade(99);
			pessoa.setNome("Nome atualizado 2");
			
			daoGeneric.atualizar(pessoa);
			
        } catch(Exception e) {
            // Ignora o erro e não faz nada
        }
	}
	
	@Test
	public void testeDelete() {
		DAOGeneric<UsuarioPessoa> daoGeneric = new DAOGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(2L, UsuarioPessoa.class);
		
		daoGeneric.deletar(pessoa);
	}
	
	@Test
	public void testeConsultar() {
		DAOGeneric<UsuarioPessoa> daoGeneric = new DAOGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> List  = daoGeneric.listar(UsuarioPessoa.class);
		
		for(UsuarioPessoa usuarioPessoa : List) {
			System.out.println(usuarioPessoa);
		}
	}
	
	@Test
	public void testQueryList() {
		DAOGeneric<UsuarioPessoa> daoGeneric = new DAOGeneric<UsuarioPessoa>();
		@SuppressWarnings("unchecked")
		List<UsuarioPessoa> List  = daoGeneric.getEntityManager().createQuery(" FROM UsuarioPessoa ORDER BY id").setMaxResults(4).
				getResultList();
		
		for (UsuarioPessoa usuarioPessoa : List) {
			System.out.println("----------------------------------------------------------------------------------------------------------"
					+ "-----------------------------");
			System.out.println(usuarioPessoa);
		}
	}
	
	@Test
	public void testQueryListParameter() {
		DAOGeneric<UsuarioPessoa> daoGeneric = new DAOGeneric<UsuarioPessoa>();
		@SuppressWarnings("unchecked")
		List<UsuarioPessoa> List  = daoGeneric.getEntityManager().createQuery(" FROM UsuarioPessoa WHERE nome = :nome"
				+ " OR sobrenome = :sobrenome").
				setParameter("nome", "Luiz").
				setParameter("sobrenome", "Gomes").
				getResultList();
		
		for (UsuarioPessoa usuarioPessoa : List) {
			System.out.println("----------------------------------------------------------------------------------------------------------"
					+ "-----------------------------");
			System.out.println(usuarioPessoa);
		}
	}
	
	@Test
	public void testeSoma() {
		DAOGeneric<UsuarioPessoa> daoGeneric = new DAOGeneric<UsuarioPessoa>();
		
		Long somaIdade = (Long) daoGeneric.getEntityManager().createQuery("SELECT SUM(u.idade) FROM UsuarioPessoa u").getSingleResult();
		System.out.println(somaIdade);
	}
	
	@Test
	public void testeNameQuery1() {
		DAOGeneric<UsuarioPessoa> daoGeneric = new DAOGeneric<UsuarioPessoa>();
		@SuppressWarnings("unchecked")
		List<UsuarioPessoa> List = daoGeneric.getEntityManager().createNamedQuery("UsuarioPessoa.todos").getResultList();
		for (UsuarioPessoa usuarioPessoa : List) {
			System.out.println("----------------------------------------------------------------------------------------------------------"
					+ "-----------------------------");
			System.out.println(usuarioPessoa);
		}
	}
	
	@Test
	public void testeNameQuery2() {
		DAOGeneric<UsuarioPessoa> daoGeneric = new DAOGeneric<UsuarioPessoa>();
		@SuppressWarnings("unchecked")
		List<UsuarioPessoa> List = daoGeneric.getEntityManager().createNamedQuery("UsuarioPessoa.buscarNome").
		setParameter("nome", "Luiz").
		getResultList();
		for (UsuarioPessoa usuarioPessoa : List) {
			System.out.println("----------------------------------------------------------------------------------------------------------"
					+ "-----------------------------");
			System.out.println(usuarioPessoa);
		}
	}
}