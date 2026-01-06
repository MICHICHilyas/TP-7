# TP 7 : JAX-RS / Jersey

> **Auteur** : Ilyas MICHICH  
> **Date** : Janvier 2026  
> **Technologies** : Java EE, JAX-RS, Jersey, Maven

## 📖 Description

Ce projet implémente une **API REST** en utilisant **JAX-RS** avec l'implémentation **Jersey**. Il démontre la création de services web RESTful conformes aux standards Java EE.

## 🏗️ Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                 Client HTTP                                  │
│           (Postman, cURL, Browser)                           │
└─────────────────────┬───────────────────────────────────────┘
                      │ HTTP Request
                      ▼
┌─────────────────────────────────────────────────────────────┐
│              Jersey Servlet Container                        │
│                  (JAX-RS)                                    │
└─────────────────────┬───────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────┐
│               Resource Classes                               │
│        @Path, @GET, @POST, @PUT, @DELETE                    │
└─────────────────────────────────────────────────────────────┘
```

## 🔑 Annotations JAX-RS

- `@Path` : Définit le chemin de la ressource
- `@GET`, `@POST`, `@PUT`, `@DELETE` : Méthodes HTTP
- `@Produces`, `@Consumes` : Types de médias
- `@PathParam`, `@QueryParam` : Paramètres

## 🚀 Déploiement

```bash
mvn clean package
# Déployer le WAR sur Tomcat/GlassFish
```

## 📸 Captures d'écran

### Test API REST
![API Test](img.png)

### Réponse JSON
![JSON Response](img_1.png)

---

**TP 7** - JAX-RS / Jersey  
*Projet réalisé par Ilyas MICHICH - Janvier 2026*
