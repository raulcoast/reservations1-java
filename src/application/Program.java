package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// Reservas Hotel
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("=============Reservas=============");
		System.out.print("Informe o Número do quarto: ");
		int number = sc.nextInt();
		System.out.print("Data do Check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do Check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: a data de check-out deve ser posterior à data de check-in");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.print("Reserva: " + reservation);
			
			System.out.println();
			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva: ");
			System.out.print("Data do Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			String erro = reservation.updateDates(checkIn, checkOut);
			if (erro != null) {
				System.out.println("Erro na reserva: " + erro );
			}
			else {
				System.out.println("Reserva :" + reservation);
			}
		}
		sc.close();
	}

}
