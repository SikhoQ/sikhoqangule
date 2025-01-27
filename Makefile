APP_NAME=sikhoqangule-waste-sorting-api
JAR_FILE=target/${APP_NAME}-0.0.1-SNAPSHOT.jar

.PHONY: clean build run test package verify all

all: clean build test verify package run

clean:
	@echo "🧹 Cleaning the project..."
	@mvn clean
	@echo "✅ Clean complete."

build: clean
	@echo "🔨 Building the project..."
	@mvn compile
	@echo "✅ Build complete."

run:
	@echo "🚀 Running the application..."
	@mvn spring-boot:run
	@echo "🛑 Application stopped."

test:
	@echo "🧪 Running tests..."
	@mvn test
	@echo "✅ Tests complete."

package:
	@echo "📦 Packaging the application into a JAR..."
	@mvn package -DskipTests
	@echo "✅ Package complete. JAR file created: ${JAR_FILE}"

verify:
	@echo "🔍 Verifying the project..."
	@mvn verify
	@echo "✅ Verification complete."
