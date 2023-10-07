package dominio;

import java.util.Map;
import java.util.Date;

public class CalculadoraSalario {
    public static double calcularSalario(String cargo, Map<Date, Double> horario_registro){
        double salario = 0.0;

        if (cargo.equals("Veterinario")) {
            salario = calcularHorasTrabajadas(horario_registro) * 10000;
        } else if (cargo.equals("Auxiliar")) {
            salario = calcularHorasTrabajadas(horario_registro) * 8000;
        } else if (cargo.equals("Secretaria")) {
            salario = calcularHorasTrabajadas(horario_registro) * 6000;
        }

        return salario;
    }
    
    private static double calcularHorasTrabajadas(Map<Date, Double> horario_registro) {
        double horas_trabajadas = 0.0;

        for (double horas : horario_registro.values()) {
            horas_trabajadas += horas;
        }

        return horas_trabajadas;
    }
}
