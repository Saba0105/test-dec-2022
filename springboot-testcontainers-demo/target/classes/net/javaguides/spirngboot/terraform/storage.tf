TerraformOptions options = new TerraformOptions();
options.setArmSubscriptionId("<Azure Subscription ID>");
options.setArmClientId("<Azure Client ID>");
options.setArmClientSecret("<Azure Client Secret>");
options.setArmTenantId("<Azure Tenant ID>");

try (TerraformClient client = new TerraformClient(options)) {
    client.setOutputListener(System.out::println);
    client.setErrorListener(System.err::println);

    client.setWorkingDirectory("/some/local/path/");
    client.plan().get();
    client.apply().get();
}