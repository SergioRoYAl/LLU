#!/bin/bash

puertos=(443 3306 80 8443)

for puerto in ${puertos[@]}; 
do
	proceso_id=$(sudo lsof -i :$puerto | tr -s " " | cut -f2 -d" " | tail -n +2)
	if [ -n "$proceso_id" ]; then
	sudo kill -9 $proceso_id
	echo "Se han eliminado los servicios en el puerto $puerto"
	else
		echo "No se han encontrado servicios asociados al puerto $puerto"
	fi
done

echo "PROCEDIENDO A INICIAR DOCKER COMPOSE"
cd ~/docker-compose-lamp
sudo docker-compose up -d
