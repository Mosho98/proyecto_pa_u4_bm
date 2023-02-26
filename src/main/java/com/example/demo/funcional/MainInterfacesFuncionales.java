package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
//1.SUPPLIER
		LOG.info("1. SUPPLIER");
		//Clases
		IPersonaSupplier<String> supplier1 = new PersonaSupplierImp();
		LOG.error("Supplier Clase: " + supplier1.getNombre());
		//Lambdas
		IPersonaSupplier<String> supplier2 = () -> "Bryan 2";
		LOG.info("Supplier Lambda: " + supplier2.getNombre());
		
		IPersonaSupplier<Integer> supplier3 = () -> Integer.valueOf(5);
		LOG.info("Supplier Lambda: " + supplier3.getNombre());
		
		IPersonaSupplier<Persona> supplier4 = () -> {
			Persona per = new Persona();
					per.setApellido("Mullo");
					per.setNombre("Bryan");	
					return per;
					};
					LOG.info("Supplier Lambda: " + supplier4.getNombre());
					
		IPersonaSupplier<Persona> supplier5 = new PersonaSupplier2Impl();
		LOG.info("Supplier Lambda: " + supplier5.getNombre());
		
		//JAVA
		LOG.info("JAVA Supplier");
		Stream<String> lista = Stream.generate(() -> {
			
			return "Bryan 2";
			}).limit(10);
		lista.forEach(cadena-> LOG.info(cadena));
		System.out.println("-------------------------------------------------------");
		
		
		
		
		
		
		
		
		
		
		
		
		
		//2.CONSUMER
				LOG.info("2. CONSUMER");
				
				//CLASE
				IPersonaConsumer<String, Integer> consumer1 = new PersonaConsumerImpl();
				consumer1.accept("procesa este dato", Integer.valueOf(10));
				
				//LAMBDA
				//EJEMPLO1
				IPersonaConsumer<String, Integer> consumer2 = (cadena, numero) -> {
					LOG.info("Mensaje a: " + cadena);
					LOG.info("Mensaje b: " + cadena);
					LOG.info("Mensaje c: " + numero);
					
				};
				consumer2.accept("Procesa este dato 2", Integer.valueOf(15));
				
				//EJEMPLO2
				IPersonaConsumer<Integer, Integer> consumer3 = (valor1, valor2) ->{
					Integer valor3 = valor1.intValue()+valor2.intValue();
					LOG.info("Valor 3= " + valor3);
				};
				consumer3.accept(Integer.valueOf(5), Integer.valueOf(10));
				
				//JAVA
				LOG.info("JAVA Consummer");
				List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5,56,78);
				listaNumeros.forEach(numero -> LOG.info("valor: " + numero));
				System.out.println("-------------------------------------------------------");
//				for(Integer val: listaNumeros) {
//					LOG.info("valor: " + val);
//				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				//3.PREDICATE
				LOG.info("3. PREDICATE");
				
				//LAMBDAS
				IPersonaPredicate<String> predicate1 = cadena -> cadena.contains("Z");
				LOG.info("Predicate: " + predicate1.evaluar("BryanZ"));
				
				//EJEMPLO2
				IPersonaPredicate<Integer> predicate2 = numero -> {
					if(numero.intValue()>10) {
						return true;
					}else {
						return false;
					}
				};
				LOG.info("Predicate2: " + predicate2.evaluar(Integer.valueOf(11)));
				
				//JAVA
				LOG.info("JAVA Predicate");
				Stream<Integer> listaFiltrada = listaNumeros.stream().filter(numero -> numero >= 3);			
				listaFiltrada.forEach(numero -> LOG.info("Valor: " + numero));
				System.out.println("-------------------------------------------------------");
				
				
				
				
				
				
				
				
				
				
				
				//4.FUNCTION
				LOG.info("4. FUNCTION");
				
				//LAMBDAS
				//PRIMEOR EL RETORNO Y LUEGO LO QUE RECIBE
				IPersonaFunction<String, Integer> function = numero -> "Valor: " + numero.toString();
				LOG.info(function.aplicar(10));
				
				//EJEMPLO2
				IPersonaFunction<Ciudadano, Persona> function2 = per -> {
					Ciudadano ciu = new Ciudadano();
					ciu.setNombreCompleto(per.getNombre() + " " + per.getApellido());
					ciu.setCiudad("Quito");
					return ciu;
				};
				
				Persona per1 = new Persona();
				per1.setNombre("Bryan");
				per1.setApellido("Mullo");
				
				Ciudadano ciudadanoConvertido = function2.aplicar(per1);
				LOG.info("Ciudadano convertido: " + ciudadanoConvertido);
				
				
				//JAVA
				LOG.info("JAVA FUNCTION");
				Stream<String> listaCambiada = listaNumeros.stream().map(numeroLista -> {
					Integer valorFinal = numeroLista+1;
					String cadena = "num: " + valorFinal.toString();
					return cadena;
				});
				listaCambiada.forEach(cadena -> LOG.info(cadena));
				System.out.println();
				
				System.out.println("UN UNARYOPERATOR MEDIANTE UN FUNCTION-------------------------");
				LOG.info("JAVA FUNCTION");
				Stream<Integer> listaCambiada2 = listaNumeros.stream().map(numeroLista -> {
					Integer valorFinal = numeroLista+1;
				
					return valorFinal;
				});
				listaCambiada2.forEach(numero -> LOG.info("Valor entero: " + numero));
				System.out.println("-------------------------------------------------------");
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				//5. UNARY OPERATOR
				LOG.info("5. UNARYOPERATOR");
				IPersonaUnaryOperator<String> unaryOperator = cadena -> {
					String cadenaFinal = cadena.concat("-sufijo");
					return cadenaFinal;
				};
				LOG.info("UnaryOperator: " + unaryOperator.aplicar("Bryan"));
				System.out.println("-------------------------------------------------------");
	}

}
