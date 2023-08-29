package Hibernate;

import java.util.List;

import org.junit.Test;

import DAO.DAOGeneric;
import model.UsuarioPessoa;

public class teste {
	
	@Test
	public void testeHibernate() {
		DAOGeneric<UsuarioPessoa> daoGeneric = new DAOGeneric<UsuarioPessoa>();
		//DAOGeneric<TEST> Test = new DAOGeneric<TEST>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		//TEST test = new TEST();
	
		//test.setNome("ui papai");
		//test.setTest("teste");
		
		//Test.salvar(test);
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
}
