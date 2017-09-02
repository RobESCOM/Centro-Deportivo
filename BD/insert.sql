use centroDeportivo;

/* Llenado de la tabla Estatus */
insert into Estatus (estatus)
values 
	('activo(a)'),
	('cancelado(a)'),
	('suspendido(a)'),
	('baja'),
	('incapacidad');

select * from Estatus;

/* Llenado de la tabla Tipo_Empleado */
insert into Tipo_Empleado (empleado)
values
	('gerente'),
	('ventas'),
	('instructor'),
	('recepcionista'),
	('limpieza'),
    ('medico');

select * from Tipo_Empleado;

/* Llenado de la tabla Estado_Republica */
insert into Estado_Republica (nombreEstado)
	values 
		('Aguascalientes'),
		('Baja California'),
		('Baja California Sur'),
		('Campeche'),
		('Chiapas'),
		('Chihuahua'),
		('Ciudad de Mexico'),
		('Coahuila'),
		('Colima'),
		('Durango'),
		('Guanajuato'),
		('Guerrero'),
		('Hidalgo'),
		('Jalisco'),
		('Mexico'),
		('Michoacan'),
		('Morelos'),
		('Nayarit'),
		('Nuevo Leon'),
		('Oaxaca'),
		('Puebla'),
		('Queretaro'),
		('Quintana Roo'),
		('San Luis Potosi'),
		('Sinaloa'),
		('Sonora'),
		('Tabasco'),
		('Tamaulipas'),
		('Tlaxcala'),
		('Veracruz'),
		('Yucatan'),
		('Zacatecas');

select * from Estado_Republica;

/* Llenado de la tabla Enfermedad */
insert into Enfermedad (enfermedad)
values
	('Diabetes'),
	('Hipertension'),
	('Hepatitis'),
	('VIH'),
	('Cardiaca'),
	('Cancer'),
	('Obesidad'),
	('Pulmonar');

select * from Enfermedad;

/* Llenado de la tabla Membresia */
insert into Membresia (idMembresia, costo, Estatus_idEstatus)
values
	('Basica', 499, 1),
	('Premium', 799, 1),
	('Platino', 1099, 1);

select * from membresia
order by costo;
    
/* Llenado de la tabla Ubicacion */
insert into Ubicacion (nombre)
values
	('vestidores'),
    ('tratamientos'),
    ('zona cardiovascular'),
	('gimnasio'),
    ('piscina'),
    ('sala de relajacion'),
    ('rings');

select * from Ubicacion;
    

/* Llenado de la tabla Servicio */
insert into Servicio (nombreServicio, costoExtra, descripcion, Estatus_idEstatus, Ubicacion_idUbicacion)
values	
	('locker', 0.00, 'un casillero para guardar articulos personales del socio', 1, 1),
	('regaderas', 0.00, 'estancia para tomar una ducha', 1, 1),
	('cardio', 0.00, 'actividades para la quema de grasa', 1, 3),
	('pesas', 0.00, 'actividades para aumentar tu volumen', 1, 4),
	('spa', 120.00, 'zona de relajacion que incluye masaje, tratamiento facial, manicure y pedicure', 1, 2),
	('seguimiento nutricional', 85.00, 'asesoria de un experto para el cumplimiento de una dieta balanceada', 3, 2),
	('entrenador personal', 35.00, 'asesoria personalizada con un instructor del gimnasio', 1, 4),
	('piscina', 200.00, 'acceso a la alberca', 1, 5),
	('vapor', 100.00, 'baño sauna', 4, 1),
	('yoga', 45.00, 'ejercicios corporales de relajacion', 1, 6),
    ('pilates', 45.00, 'ejercicios de estiramiento', 1, 6),
    ('spinning', 75.00, 'trabajo cardiovascular por medio de la bicicleta', 1, 3),
    ('box', 100.00, 'entrenador profesional en el arte del boxeo', 1, 7),
    ('mma', 200.00, 'se enseñan artes marciales mixtas mediante un entrenador profesional', 1, 7);
    
select * from servicio;

