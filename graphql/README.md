# About

Make Graphql sample source code.

# Keywords

- Graphql
- GraphiQL

# How to run this source

I'm using VSCode editor, thus following steps are for VSCode.

1. import graphql folder to workspace.
2. Install VSCode extension "Lombok Annotations Supprt for VS Code".
3. Run StudyJavaApplication.java.
4. Access to [Local GraphiQL](http://localhost:8080/graphiql)
5. if run following query, fixed sample data will be returned.

```
query {
  bookById(id:1) {
    id
    name
  }
}
```
