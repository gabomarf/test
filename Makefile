VERSION ?= $(shell git rev-parse HEAD)
APP     ?= app-region
IMAGE   ?= $(APP):$(VERSION)

ifeq ($(MVN),)
    MVN  := mvn
endif

.PHONY: build

all: build push

build:
	@ $(MVN) clean install -U
	docker build -t $(IMAGE) .
run:
	docker run -idt --name=$(APP) -p8080:8080 $(IMAGE)
