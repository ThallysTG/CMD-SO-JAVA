package atividade;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class Principal {

	public static void main(String[] args) throws IOException {

		String nomePasta;
		String nomeArquivo;
		String textoRenomear;
		String texto;
		String extensaoArq;
		String acessoPasta = null;

		Scanner scan = new Scanner(System.in);

		boolean condicao = true;
		while (condicao == true) {

			System.out.println("Digite a opção desejada ");
			System.out.println("1: ACESSAR PASTA");
			System.out.println("2: CRIAR UMA PASTA");
			System.out.println("3: EXCLUIR UMA PASTA");
			System.out.println("4: CRIAR UM ARQUIVO");
			System.out.println("5: INSERIR TEXTO EM UM ARQUIVO");
			System.out.println("6: LISTAR ARQUIVOS E DIRETÓRIOS DA PASTA");
			System.out.println("7: RENOMEAR UM ARQUIVO OU DIRETÓRIO");
			System.out.println("8: MOVER ARQUIVO OU DIRETÓRIO");
			System.out.println("9: AJUDA");
			System.out.println("10: IMPRIMIR A VERSÃO DO SISTEMA OPERACIONAL");
			System.out.println("11: IMPRIMIR A DATA ATUAL");
			System.out.println("12: IMPRIMIR A HORA ATUAL");
			System.out.println("13: SAIR");

			int i = scan.nextInt();
			scan.nextLine(); // GAMBIARRA SCANNER

			switch (i) {
			case 1: // ACESSAR DIRETORIO
				System.out.println("\nDigite o caminho para acessar: ");
				acessoPasta = scan.nextLine();
				break;

			case 2: // CRIAR PASTA
				if (acessoPasta != null) {
					System.out.println("\nDigite nome da pasta para Criar: ");
					nomePasta = scan.nextLine();

					// Criar Pasta
					File pasta = new File(acessoPasta, nomePasta);
					pasta.mkdir();
					System.out.println(pasta);

				} else {
					System.out.println("\nInserir caminho primeiro!");
				}
				break;

			case 3: // EXCLUIR PASTA
				if (acessoPasta != null) {
					System.out.println("\nDigite nome da pasta para Excluir: ");
					nomePasta = scan.nextLine();

					// Excluir Pasta
					File pasta = new File(acessoPasta, nomePasta);
					pasta.delete();
					System.out.println(pasta);

				} else {
					System.out.println("\nInserir caminho primeiro!");
				}
				break;

			case 4: // CRIAR UM ARQUIVO
				if (acessoPasta != null) {
					System.out.println("\nDigite nome do arquivo para criar: ");
					nomeArquivo = scan.nextLine();
					System.out.println("\nO Arquivo é: " + "\n(1) Imagem " + "\n(2) Texto");
					extensaoArq = scan.nextLine();
					if (extensaoArq == "1") {
						extensaoArq = ".jpg";
					} else {
						extensaoArq = ".txt";
					}
					// Criar Arquivo

					File arquivo = new File(acessoPasta, nomeArquivo + extensaoArq);
					arquivo.createNewFile();
					System.out.println(arquivo);

				} else {
					System.out.println("\nInserir caminho primeiro!");
				}
				break;

			case 5: // INSERIR O TEXTO
				if (acessoPasta != null) {
					File file = new File(acessoPasta);
					System.out.println("\nInsira o texto: ");
					texto = scan.nextLine();
//				PrintWriter texto = new PrintWriter(file);

					try {
						PrintWriter output = new PrintWriter(new FileWriter(acessoPasta, true));
						output.print(texto);
						output.close();
						output = null;

					} catch (Exception ex) {
						System.out.println("ERROR");

					}
				}
				break;

			case 6: // LISTAR ARQUIVOS E DIRETORIOS DA PASTA
				if (acessoPasta != null) {
					File file = new File(acessoPasta);
					File afile[] = file.listFiles();
					int i1 = 0;
					for (int j = afile.length; i1 < j; i1++) {
						File arquivos = afile[i1];
						System.out.println(arquivos.getName());

					}
				}
				break;

			case 7: // RENOMEAR UM ARQUIVO OU DIRETORIO
				if (acessoPasta != null) {

					System.out.println("Digite o nome do novo arquivo ou diretório: ");
					textoRenomear = scan.nextLine();

//				new File(acessoPasta).renameTo(new File(acessoPasta, textoRenomear));
//				System.out.println("\nRenomeado com Sucesso!");

					// Arquivo ou diretório com nome antigo
					File file = new File(acessoPasta); //
					// Arquivo ou diretório com novo nome
					File file2 = new File(textoRenomear); //
					// Renomeando arquivo ou diretório
					boolean success = file.renameTo(file2);
					if (!success) {
						System.out.println("Falha no momento de renomear");
					}

				}
				break;

			case 8: // MOVER ARQUIVOS OU DIRETORIO
				if (acessoPasta != null) {

					System.out.println("Digite o novo diretorio do arquivo ou pasta: ");
					String diretorioDestino = scan.nextLine();

					// ARQUIVO OU PASTA A SER MOVIDO
					File file = new File(acessoPasta);
					// ARQUIVO OU PASTA DESTINO
					File file2 = new File(diretorioDestino);

					boolean sucesso = file.renameTo(new File(diretorioDestino, file.getName()));
					if (sucesso) {
						System.out.println("Arquivo movido com sucesso");
					} else {
						System.out.println("Erro ao mover arquivo");
					}
				}

				break;

			case 9:
				break;

			case 10:
				System.out.println(System.getProperty("os.name"));
				System.out.println(System.getProperties());
				break;

			case 11:
				Date atual = new Date();
				System.out.print("\n A data atual é: ");
				System.out.println(atual);
				break;
			case 12:
				Date relogio = new Date();
				System.out.print("\n A hora atual é: ");
				System.out.println(relogio.toString());
				break;

			case 13: // SAIR
				condicao = false;
				break;
			default:
				break;

			}

		}

	}

}