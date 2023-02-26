package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaFunction<R, T> {

	public R aplicar(T arg1);//PRIMERO EL RETORNO Y LUEGO LO QUE RECIBE
}
