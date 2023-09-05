package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

	private String nome;
	private String email;
	private Date dataNascimento;
	
	SimpleDateFormat dn = new SimpleDateFormat ("(dd/MM/yyyy)");
	
	
	public Client() {
	}
	
	public Client(String nome, String email, Date dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNacimento() {
		return dataNascimento;
	}

	public void setDataNacimento(Date dataNacimento) {
		this.dataNascimento = dataNacimento;
	}

	@Override
	public String toString() {
		return nome + " " + dn.format(dataNascimento) + " - " + email ;
	}

	
}
