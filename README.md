# spring-boot-ecs-starter
A starter project for Spring Boot microservices to deploy on ECS

This starter kit includes the following artifacts:

<b>springbootservice:</b> this is a Java Spring Boot sample microservice

<b>spring-boot-ecs-service-ALB.template:</b> this is template file to launch CloadFormation stack

<b>ResourcesToBeCreated:</b> This diagram shows the resources that will be created by the CloudFormation stack

Steps to build the microservice and launch the CloudFormation stack to create ECS Cluster

<b> Build your applciation jar:<b> "mvn clean install" from root directory of the springbootservice application

<b> Build Docker image : </b> "docker build -t springbootservice ." from root directory

<b> Host the Docker image:</b> Host this docker image to Docker hub

<b> Launch ECS Cluster from CloudFormation: </b> Use spring-boot-ecs-service-ALB.template to launch the cluster.
You can either save it an s3 bucket and refer during launching the CF stack or copy its content and paste in designer.

The template uses image nkkaushik/springbootservice:firstimg hosted on docker hub,
you can use your own image hosted in last step, to do so, search for "image" in the template and replace it with your image.

When you will launch the CloudFormation stack, provide some values when asked like Cluster name, VPC, Subnets.... 
Wait untill Stack status is shown as Complete

Check in Load Balancers list under EC2 Service, you will see a newly created ALB with name ECSALB.
Access its DNS with as mentioned below, please use the DNS of your ALB and not the one shown below.

http://ecsalb-1751260684.us-east-1.elb.amazonaws.com 
You will see message "Welcome to the 3Pilar Global springboot service sample"

http://ecsalb-1751260684.us-east-1.elb.amazonaws.com/hello
You will see message "Hello, how are you today..."

Please check other resources created by CloudFormation.

Once done, go and check the box again CloudFormation Stack and from Actions choose Delete Stack, this will delete all the resources created by the Stack.