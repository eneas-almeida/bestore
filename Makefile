.PHONY: run

run:
	clear && mvn spring-boot:run

.PHONY: up

up:
	docker-compose up -d

.PHONY: down

down:
	docker-compose down
