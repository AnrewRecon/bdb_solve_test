# Run test solved
## Requirements

Have Git installed
Have maven installed and have environment variables configured.

Have an account on Docker Hub.

Have Docker installed.

Have docker-compose installed.

Have install angular cli.

Do not have services running on the ports (4200, 23306 and 8080).

## Test
clone the repository
```bash
git clone https://github.com/AnrewRecon/bdb_solve_test.git
```

### MySql
Open folder docker_mysql
Open console and run 

```bash
docker-compose up -d
```

### API
Open folder ApiBdb
open console and run 


```bash
mvn clean install
cd target/
java -jar apirest-1.0.0.jar
```

### Front
open folder bdbfront
open console and run
```bash
npm i
ng serve
```
