package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.model.Carro;
import br.com.util.NotificationsUtils;

@ManagedBean(name = "CarroDaoMB")
public class CarroDAO<obj> {
	Carro carro = new Carro();
	List<Carro> listcarros = new ArrayList<Carro>();
	String pegavalor;

	public Session getSessao() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		return session;
	}

	public List<Carro> gerarTabela() {
		Session session = getSessao();

		// cria a lsta com os atributos carros
		listcarros = session.createQuery("from Carro").list(); // faz a query e lista

		session.close();

		return listcarros; // retorna a listcarros com a query
	}

	public List<Carro> pesquisarTabela(Carro car) {
		Session session = getSessao();

		List<Carro> listcarros = new ArrayList<Carro>();
		listcarros = session
				.createQuery(
						"from Carro where marca like'" + car.getMarca() + "' or modelo like '" + car.getMarca() + "'")
				.list();

		session.close();

		return listcarros;
	}

	public void adicionarCarro(Carro car) {

		Session session = getSessao();

		car.setMarca(car.getMarca());
		car.setModelo(car.getModelo());
		car.setCor(car.getCor());
		car.setAno(car.getAno());
		car.setValor(car.getValor());
		car.setDescricao(car.getDescricao());

		session.save(car);
		NotificationsUtils.saveMessage();
		session.getTransaction().commit();

		session.close();

	}

	public void apagarCarro(Carro car) {
		Session session = getSessao();

		session.delete(car);
		session.getTransaction().commit();

		session.close();
	}

	public void editarCarro(Carro car) {

		Session session = getSessao();

		car.getId();
		car.setValor(pegavalor);

		System.out.println("Id: " + car.getId() + " Valor: " + pegavalor);

		session.update(car);

		NotificationsUtils.editMessage();

		session.getTransaction().commit();

		session.close();

	}

}
