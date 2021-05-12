# Lab 15
## Adjacency Matrix
|   | 0 | 1 | 2 | 3 | 4 |
|---|---|---|---|---|---|
| 0 |   | 1 |   |   | 1 |
| 1 | 1 |   | 1 | 1 | 1 |
| 2 |   | 1 |   | 1 |   |
| 3 |   | 1 | 1 |   | 1 |
| 4 | 1 | 1 |   | 1 |   |

## Psudo code

Create __ArrayList__  for Vertices called adjacencyList

for each Vertex store the vertices that are connected

at the end the arrayList should look like

```javascript
[
	[1, 4],
	[0, 2, 3, 4],
	[1, 3],
	[1, 2, 4],
	[0, 1, 3]
]
```
