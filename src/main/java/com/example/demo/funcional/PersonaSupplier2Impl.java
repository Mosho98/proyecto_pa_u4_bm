package com.example.demo.funcional;

public class PersonaSupplier2Impl implements IPersonaSupplier<Persona>{

	@Override
	public Persona getNombre() {
		Persona per = new Persona();
		per.setApellido("Mullo1");
		per.setNombre("Bryan1");	
		return per;
	}

}
