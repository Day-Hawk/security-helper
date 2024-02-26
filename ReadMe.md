<h1 align="center">Security</h1> <br>

<div align="center">

![Java Version](https://img.shields.io/badge/Java-17-important?style=for-the-badge&logo=java)
[![Support Server](https://img.shields.io/discord/678733739504697375.svg?color=7289da&label=dotSpace%20Dev&logo=discord&style=for-the-badge)](https://discord.gg/mFfDMAEFWE)


A library which is the core of our projects and can be used for other cool projects as well.

</div>

----

## General Information

The library simply makes it easier to work with the existing hash functions and ciphers.
The supported versions depend on the jar version used.

----

## Code

Here is a complete example with all functions.

```
final ICryptManager cryptManager = CryptManager.instance();
final IHashManager hashManager = HashManager.instance();

//Print supported.

//1
System.out.println(cryptManager.algorithmList());
//2
System.out.println(hashManager.algorithmList());

final IHashProcessor hashProcessor = hashManager.processor("SHA3-256");

//Create key
final byte[] d = hashProcessor.hash("325".getBytes()).digest();

final ICryptProcessor cryptProcessor = cryptManager.processor("AES");
final Key key = new SecretKeySpec(Arrays.copyOf(d, 16), "AES");

final String value = "This text should be encrypted.";

final ICryptValue encrypted = cryptProcessor.encrypt(key, value.getBytes());
final ICryptValue decrypted = cryptProcessor.decrypt(key, encrypted.data());

final String decryptedValue = new String(decrypted.data());

//3
System.out.println(/*True*/value.equals(decryptedValue));
```

**output >>**

```
1 > [PBEWithMD5AndDES, AES/GCM/NoPadding, PBEWithSHA1AndRC2_128, AES_192/ECB/NoPadding, AES_128/KW/NoPadding,
PBEWithSHA1AndRC2_40, PBEWithSHA1AndRC4_128, DESedeWrap, AES_256/KW/NoPadding, AES/KW/NoPadding, PBEWithSHA1AndDESede, PBEWithSHA1AndRC4_40, AES_192/KWP/NoPadding, PBEWithHmacSHA224AndAES_128, AES, AES_192/OFB/NoPadding, AES_192/CFB/NoPadding, AES_192/KW/NoPadding, AES_192/GCM/NoPadding, AES_192/CBC/NoPadding, AES_128/KW/PKCS5Padding, DESede, AES_256/KW/PKCS5Padding, AES_128/ECB/NoPadding, AES_256/ECB/NoPadding, ChaCha20-Poly1305, AES/KW/PKCS5Padding, ARCFOUR, AES_256/GCM/NoPadding, RC2, RSA, AES_128/CFB/NoPadding, AES_128/KWP/NoPadding, AES_128/OFB/NoPadding, AES_256/KWP/NoPadding, ChaCha20, PBEWithHmacSHA224AndAES_256, DES, AES_256/CBC/NoPadding, PBEWithHmacSHA256AndAES_256, PBEWithHmacSHA256AndAES_128, AES/KWP/NoPadding, AES_192/KW/PKCS5Padding, AES_256/CFB/NoPadding, PBEWithHmacSHA512AndAES_128, PBEWithHmacSHA1AndAES_128, PBEWithHmacSHA512AndAES_256, AES_128/CBC/NoPadding, AES_256/OFB/NoPadding, PBEWithHmacSHA1AndAES_256, PBEWithHmacSHA384AndAES_256, AES_128/GCM/NoPadding, PBEWithHmacSHA384AndAES_128, Blowfish, PBEWithMD5AndTripleDES, RSA/ECB/PKCS1Padding, RSA]

2 > [SHA3-512, SHA-1, SHA-384, SHA3-384, SHA-224, SHA-512/256, SHA-256, MD2, SHA-512/224, SHA3-256, SHA-512, MD5,
SHA3-224]

3 > true
```

The library is very easy to use, just try it out.
