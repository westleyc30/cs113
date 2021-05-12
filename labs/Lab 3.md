# Lab 3
## Self Check
1.  a. O(n^2)  
    b. O(n)  
    c. O(n^2)  
    d. O(n)
	
## Programming
```
 int n = 100;
 int y1;

 int y2;

 for (int i \= 0; i < n; i+=10) {
 		y1 \= 100 \* i + 10;
 		y2 \= 5 \* i \* i + 2;
		System.out.println("y1: after " + i + " increments: " + y1);
 		System.out.println("y2: after " + i + " increments: " + y2);
 	}
}

```

y1 is O(N)
y2 is O(N^2)

y1 is larger when n < 20 even though it is O(N) runtime compared to O(N^2)