import java.util.LinkedList;
import java.util.Scanner;

public class App 
{

    public static void main(String[] args) 
    {
        System.out.println("PROGRAMA INICIADO");
        System.out.println("-----------------");
        System.out.println("");
        
        // Voy a solicitar el tamano inicial de mi cola
        int size = 0;
        Scanner in = new Scanner (System.in);
        while (size == 0)
        {
            System.out.println("Cuantos empleados va a procesar?.");
            try
            {
                size = Integer.parseInt(in.nextLine());
            }
            catch (NumberFormatException numberFormatException)
            {
                System.out.println("Debe ingresar un numero.");
                System.out.println("");
            }
        }
        
        // Voy a crear la lista
        LinkedList<Trabajador> cola = new LinkedList<>();
        for (int i = 1; i <= size; i++)
        {
            Trabajador trabajador = new Trabajador();
            System.out.println("");
            
            try
            {
                // Voy a pedir los datos de cada trabajador
                System.out.println("Ingrese el documento del trabajador " + i);
                trabajador.setDocumento(Integer.parseInt(in.nextLine()));
                System.out.println("Ingrese el nombre del trabajador " + i);
                trabajador.setNombre(in.nextLine());
                System.out.println("Ingrese el apellido del trabajador " + i);
                trabajador.setApellido(in.nextLine());
                System.out.println("Ingrese el salario diario del trabajador " + i);
                trabajador.setSalario(Double.parseDouble(in.nextLine()));
                System.out.println("Ingrese el numero de horas diarias trabajador " + i);
                trabajador.setHoras(Integer.parseInt(in.nextLine()));
                System.out.println("Ingrese el numero de dias que no laboro " + i);
                trabajador.setAusencia(Integer.parseInt(in.nextLine()));
                
                cola.offer(trabajador);
            }
            catch (NumberFormatException numberFormatException)
            {
                System.out.println("Debe ingresar un numero en este campo.");
                i--;
            }
        }
        // Voy a procesar a los trabajadores
        System.out.println("");
        System.out.println("El reporte de sus empleados es el siguiente:");
        System.out.println("--------------------------------------------");
        System.out.println("");
        for (int i = 0; i < size; i++)
        {
            // Voy a calcular y mostrar
            Double valorHoraMedio = cola.peek().getSalario() / 8;
            Double valorHoraBruto = cola.peek().getSalario()/cola.peek().getHoras();
            Double salarioMensualB = cola.peek().getSalario() * 30;
            Double salarioMensualN = cola.peek().getSalario() * (30 - cola.peek().getAusencia());
            System.out.println(cola.peek().getDocumento() + " - " + cola.peek().getNombre() + " " + cola.peek().getApellido());
            System.out.println("Valor hora bruto: $" + valorHoraBruto);
            System.out.println("Valor hora promedio (8 horas): $" + valorHoraMedio);
            System.out.println("Salario mensual bruto (30 dias): $" + salarioMensualB);
            System.out.println("Salario mensual neto (bruto - ausencias): $" + salarioMensualN);
            System.out.println("");
            cola.poll();
        }
    }

    
    private static class Trabajador 
    {
        private Integer documento;
        private String nombre;
        private String apellido;
        private Double salario;
        private Integer horas;
        private Integer ausencia;

        public Integer getDocumento()
        {
            return documento;
        }

        public void setDocumento(Integer documento)
        {
            this.documento = documento;
        }

        public String getNombre()
        {
            return nombre;
        }

        public void setNombre(String nombre)
        {
            this.nombre = nombre;
        }

        public String getApellido()
        {
            return apellido;
        }

        public void setApellido(String apellido)
        {
            this.apellido = apellido;
        }

        public Double getSalario()
        {
            return salario;
        }

        public void setSalario(Double salario)
        {
            this.salario = salario;
        }

        public Integer getHoras()
        {
            return horas;
        }

        public void setHoras(Integer horas)
        {
            this.horas = horas;
        }

        public Integer getAusencia()
        {
            return ausencia;
        }

        public void setAusencia(Integer ausencia)
        {
            this.ausencia = ausencia;
        }
        
    }
}