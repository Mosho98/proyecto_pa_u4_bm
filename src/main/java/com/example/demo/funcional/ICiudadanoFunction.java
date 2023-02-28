package com.example.demo.funcional;

@FunctionalInterface
public interface ICiudadanoFunction<R, T> {

	public R aplicarEst(T arg1);//PRIMERO EL RETORNO Y LUEGO LO QUE RECIBE
}
