param(
    [string]$Module = 'abs'
)

$pom = Join-Path -Path $PSScriptRoot -ChildPath "$Module\pom.xml"
if (-not (Test-Path $pom)) {
    Write-Error "POM not found: $pom"
    exit 1
}

# Run using the module POM
mvn -f $pom spring-boot:run
