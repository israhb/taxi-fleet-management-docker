package com.mentedigital.israel.taxis.mapper;

import com.mentedigital.israel.taxis.dto.*;
import com.mentedigital.israel.taxis.dto.auth.UsuarioRequestDTO;
import com.mentedigital.israel.taxis.model.*;

import java.util.List;

public class Mapper {
    /************* Sin relacion *****************/
    public static TaxiDTO toDto(Taxi t){
        if ( t == null ) return null;
        return TaxiDTO.builder()
                .id(t.getId())
                .nombreUnidad(t.getNombreUnidad())
                .marca(t.getMarca())
                .modelo(t.getModelo())
                .anio(t.getAnio())
                .color(t.getColor())
                .placa(t.getPlaca())
                .precioCompra(t.getPrecioCompra())
                .fechaCompra(t.getFechaCompra())
                .build();
    }
    public static TipoMantenimientoDTO toDto(TipoMantenimiento t){
        if( t == null ) return null;
        return TipoMantenimientoDTO.builder()
                .id(t.getId())
                .nombre(t.getNombre())
                .build();
    }
    public static RolDTO toDto(Rol r){
        if( r == null ) return null;
        return RolDTO.builder()
                .id(r.getId())
                .nombre(r.getNombre())
                .descripcion(r.getDescripcion())
                .build();
    }
    public static ConductorDTO toDto(Conductor c){
        if( c == null ) return null;
        return ConductorDTO.builder()
                .id(c.getId())
                .nombreCompleto(c.getNombreCompleto())
                .telefono(c.getTelefono())
                .direccion(c.getDireccion())
                .numeroLicencia(c.getNumeroLicencia())
                .fechaContratacion(c.getFechaContratacion())
                .build();
    }
    public static CategoriaGastoDTO toDto(CategoriaGasto c){
        if( c == null ) return null;
        return CategoriaGastoDTO.builder()
                .id(c.getId())
                .nombre(c.getNombre())
                .build();
    }
    /************* Con relacion *****************/
    public static UsuarioDTO toDto(Usuario u){
        if( u == null ) return null;
        return UsuarioDTO.builder()
                .id(u.getId())
                .usuario(u.getUsuario())
                .password(u.getPassword())
                .nombreCompleto(u.getNombreCompleto())
                .activo(u.getActivo())
                .rol(
                        List.of(
                                RolDTO.builder()
                                        .id(u.getRol().getId())
                                        .nombre(u.getRol().getNombre())
                                        .descripcion(u.getRol().getDescripcion())
                                        .build()
                        )
                )
                .build();
    }
    public static UsuarioRequestDTO toDtoLogin(Usuario u){
        if( u == null ) return null;
        return UsuarioRequestDTO.builder()
                .id(u.getId())
                .usuario(u.getUsuario())
                .nombreCompleto(u.getNombreCompleto())
                .rol(
                        List.of(
                                RolDTO.builder()
                                        .id(u.getRol().getId())
                                        .nombre(u.getRol().getNombre())
                                        .descripcion(u.getRol().getDescripcion())
                                        .build()
                        )
                )
                .build();
    }
    public static AsignacionTaxiConductorDTO toDto(AsignacionTaxiConductor a){
        if( a == null ) return null;
        return AsignacionTaxiConductorDTO.builder()
                .id(a.getId())
                .fechaInicio(a.getFechaInicio())
                .fechaFin(a.getFechaFin())
                .activo(a.getActivo())
                .taxi(
                        List.of(
                                TaxiDTO.builder()
                                        .id(a.getTaxi().getId())
                                        .nombreUnidad(a.getTaxi().getNombreUnidad())
                                        .marca(a.getTaxi().getMarca())
                                        .modelo(a.getTaxi().getModelo())
                                        .anio(a.getTaxi().getAnio())
                                        .color(a.getTaxi().getColor())
                                        .placa(a.getTaxi().getPlaca())
                                        .precioCompra(a.getTaxi().getPrecioCompra())
                                        .fechaCompra(a.getTaxi().getFechaCompra())
                                        .build()
                        )
                )
                .conductor(
                        List.of(
                                ConductorDTO.builder()
                                        .id(a.getConductor().getId())
                                        .nombreCompleto(a.getConductor().getNombreCompleto())
                                        .telefono(a.getConductor().getTelefono())
                                        .direccion(a.getConductor().getDireccion())
                                        .numeroLicencia(a.getConductor().getNumeroLicencia())
                                        .fechaContratacion(a.getConductor().getFechaContratacion())
                                        .build()
                        )
                )
                .build();

    }
    public static GastoDTO toDto(Gasto g){
        if( g == null ) return null;
        return GastoDTO.builder()
                .id(g.getId())
                .descripcion(g.getDescripcion())
                .monto(g.getMonto())
                .fechaHoraGasto(g.getFechaHoraGasto())
                .notas(g.getNotas())
                .creadoPor(g.getCreadoPor())
                .taxi(
                        List.of(
                                TaxiDTO.builder()
                                        .id(g.getTaxi().getId())
                                        .nombreUnidad(g.getTaxi().getNombreUnidad())
                                        .marca(g.getTaxi().getMarca())
                                        .modelo(g.getTaxi().getModelo())
                                        .anio(g.getTaxi().getAnio())
                                        .color(g.getTaxi().getColor())
                                        .placa(g.getTaxi().getPlaca())
                                        .precioCompra(g.getTaxi().getPrecioCompra())
                                        .fechaCompra(g.getTaxi().getFechaCompra())
                                        .build()
                        )
                )
                .categoriaGasto(
                        List.of(
                                CategoriaGastoDTO.builder()
                                        .id(g.getCategoriaGasto().getId())
                                        .nombre(g.getCategoriaGasto().getNombre())
                                        .build()
                        )
                )
                .build();
    }
    public static IngresoDTO toDto( Ingreso i ){
        if( i == null ) return null;
        return IngresoDTO.builder()
                .id(i.getId())
                .monto(i.getMonto())
                .fechaHoraIngreso(i.getFechaHoraIngreso())
                .notas(i.getNotas())
                .creadoPor(i.getCreadoPor())
                .taxi(
                        List.of(
                                TaxiDTO.builder()
                                        .id(i.getTaxi().getId())
                                        .nombreUnidad(i.getTaxi().getNombreUnidad())
                                        .marca(i.getTaxi().getMarca())
                                        .modelo(i.getTaxi().getModelo())
                                        .anio(i.getTaxi().getAnio())
                                        .color(i.getTaxi().getColor())
                                        .placa(i.getTaxi().getPlaca())
                                        .precioCompra(i.getTaxi().getPrecioCompra())
                                        .fechaCompra(i.getTaxi().getFechaCompra())
                                        .build()
                        )
                )
                .conductor(
                        List.of(
                                ConductorDTO.builder()
                                        .id(i.getConductor().getId())
                                        .nombreCompleto(i.getConductor().getNombreCompleto())
                                        .telefono(i.getConductor().getTelefono())
                                        .direccion(i.getConductor().getDireccion())
                                        .numeroLicencia(i.getConductor().getNumeroLicencia())
                                        .fechaContratacion(i.getConductor().getFechaContratacion())
                                        .build()
                        )
                )
                .build();
    }
    public static MantenimientoTaxiDTO toDto(MantenimientoTaxi m){
        if( m == null ) return null;
        return MantenimientoTaxiDTO.builder()
                .id(m.getId())
                .descripcion(m.getDescripcion())
                .fechaHoraMantenimiento(m.getFechaHoraMantenimiento())
                .costo(m.getCosto())
                .fechaProximoMantenimiento(m.getFechaProximoMantenimiento())
                .notas(m.getNotas())
                .creadoPor(m.getCreadoPor())
                .taxi(
                        List.of(
                                TaxiDTO.builder()
                                        .id(m.getTaxi().getId())
                                        .nombreUnidad(m.getTaxi().getNombreUnidad())
                                        .marca(m.getTaxi().getMarca())
                                        .modelo(m.getTaxi().getModelo())
                                        .anio(m.getTaxi().getAnio())
                                        .color(m.getTaxi().getColor())
                                        .placa(m.getTaxi().getPlaca())
                                        .precioCompra(m.getTaxi().getPrecioCompra())
                                        .fechaCompra(m.getTaxi().getFechaCompra())
                                        .build()
                        )
                )
                .tipoMantenimiento(
                        List.of(
                                TipoMantenimientoDTO.builder()
                                        .id(m.getTipoMantenimiento().getId())
                                        .nombre(m.getTipoMantenimiento().getNombre())
                                        .build()
                        )
                )
                .build();
    }
}
