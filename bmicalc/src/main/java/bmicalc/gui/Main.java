package bmicalc.gui;

import java.awt.EventQueue;

import bmicalc.BMICalc;
import bmicalc.BMICalcImpl;


public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMICalc modelo = BMICalcImpl.getInstance();
					Vista vista = new Vista();
					Controlador controlador = new Controlador(modelo, vista);
					vista.registrarControlador(controlador);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
