package br.ufrpe.my_pigeon_study.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ManipuladorArquivo{
	private static Scanner in;
	
	public static void criarArquivo(String path) throws IOException{
		File arq=new File(path);
		arq.createNewFile();
	}
	public static boolean exist(String path) throws IOException{
		File f = new File(path);
		if (f.exists() && !f.isDirectory()) {
			return false;
		}
		return true;
	}

	public static Repositorio  leitor(String path) throws IOException{
		RepositorioUsuario usr=null;
		if(exist(path)!=true){
		    try {
		    	FileInputStream restFile = new FileInputStream(path);
			    ObjectInputStream stream = new ObjectInputStream(restFile);
				usr=(RepositorioUsuario) stream.readObject();    
				stream.close();
				restFile.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		return (RepositorioUsuario)usr;
	}
	
	public static void escritor(String path, RepositorioUsuario rep) throws IOException{
		if(exist(path)!=true){
			FileOutputStream saveFile= new FileOutputStream (path);
			ObjectOutputStream stream = new ObjectOutputStream(saveFile);
			stream.writeObject(rep);
			stream.flush();
			stream.close();
			saveFile.flush();
			saveFile.close();
		}
		else {
			criarArquivo(path);
			FileOutputStream saveFile= new FileOutputStream (path);
			ObjectOutputStream stream = new ObjectOutputStream(saveFile);
			stream.writeObject(rep);
			stream.flush();
			stream.close();
			saveFile.flush();
			saveFile.close();
		}
	}
	
}
