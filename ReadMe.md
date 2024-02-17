<h1 align="center">Security</h1> <br>

<div align="center">

![Java Version](https://img.shields.io/badge/Java-17-important?style=for-the-badge&logo=java)
[![Support Server](https://img.shields.io/discord/678733739504697375.svg?color=7289da&label=dotSpace%20Dev&logo=discord&style=for-the-badge)](https://discord.gg/mFfDMAEFWE)


A library which is the core of our projects and can be used for other cool projects as well.

</div>
----

## General Information

The library simply makes it easier to use with the existing hash functions.
The supported algorithms depend on the `MessageDigest` of the java version used.

----

## Code

### List available algorithm

All algorithms can be listed using the following method.

```
HashManager.algorithmList()
```

**output >>**

```
[SHA3-512, SHA-1, SHA-384, SHA3-384, SHA-224, SHA-512/256, SHA-256, MD2, SHA-512/224, SHA3-256, SHA-512, MD5, SHA3-224]
```

### Hash processors

Hash processors are used for the conversion.

```
final IHashProcessor hashProcessor = HashManager.processor("SHA-1");
```

**example >>**

```
final IHashProcessor hashProcessor = HashManager.processor("SHA-1"");

try {
final IHashValue content = hashProcessor.hash("Hello World!");

//Use value here (own code here)
} catch(final HashException exception) {
//Thrown if something went wrong or algorithmen of hashProcessor not present.
}
```

---
