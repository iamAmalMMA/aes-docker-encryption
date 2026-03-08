# AES Encryption Dockerized Application

![Docker Build](https://github.com/iamAmalMMA/aes-docker-encryption/actions/workflows/docker-build.yml/badge.svg)

This project demonstrates AES encryption and decryption using the ECB and CBC modes, implemented in Java.

The application is containerized using Docker to provide a reproducible runtime environment.

## CI/CD

This project uses GitHub Actions to automatically build the Docker image on every push to the main branch.

## Features

- AES encryption using ECB mode
- AES encryption using CBC mode
- Base64 encoded encrypted blocks
- Message decryption verification

## Technologies

- Java
- Docker
- AES Cryptography

## How to Run

Build the Docker image:
docker build -t aes-encryption-app .

Run the container:
docker run -it aes-encryption-app


Enter a message that is a multiple of 16 characters to see the encryption output.

## Example Usage

Example message:
hernameisjasmineababababababababhernameisjasmine

Example program output:
Enter a message (multiple of 16 characters):
hernameisjasmineababababababababhernameisjasmine

Encryption Using ECB Mode:

Message | hernameisjasmineababababababababhernameisjasmine
Encrypted Block 1 | ...
Encrypted Block 2 | ...
Encrypted Block 3 | ...

Decrypted Message | hernameisjasmineababababababababhernameisjasmine

Encryption Using CBC Mode:

Message | hernameisjasmineababababababababhernameisjasmine
Encrypted Block 1 | ...
Encrypted Block 2 | ...
Encrypted Block 3 | ...

Decrypted Message | hernameisjasmineababababababababhernameisjasmine


Note: The encrypted blocks will differ each time because a new encryption key and initialization vector are generated.

