package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import entities.services.ContractService;
import entities.services.PaypalService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Entre com os dados do contrato:");

		System.out.print("Número: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do contrato: ");
		double valorTotal = sc.nextDouble();

		Contract contract = new Contract(number, date, valorTotal);

		System.out.print("Entre com o numero de parcelas: ");
		int n = sc.nextInt();

		ContractService contractService = new ContractService(new PaypalService());

		contractService.processContract(contract, n);

		double totalInstallment = 0.0;
		System.out.println("-----------------------------------");
		System.out.println("Parcelas:");
		for (Installment installment : contract.getInstalments()) {
			System.out.println(installment);
			
			totalInstallment += installment.getAmount();
		}
		

		
		System.out.printf("TOTAL COM JUROS: %.2f", totalInstallment);
		

		sc.close();

	}

}
