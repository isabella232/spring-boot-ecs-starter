# spring-boot-ecs-starter
A starter project to deploy Spring Boot microservices in a ECS Cluster

This starter kit includes the following artifacts:

<b>springbootservice1:</b> This is a Java Spring Boot sample microservice

<b>springbootservice2:</b> This is another sample Java Spring Boot microservice

<b>ECS-CF-springboot-ALB-single-service:</b> Use this YML template file to launch CloadFormation stack for a single service (springbootservice1)

<b>ECS-CF-springboot-ALB-multiple-services:</b> This YML template launches CloadFormation stack for a multiple services (springbootservice1 & springbootservice2)

<b>ResourcesToBeCreated-single-service:</b> This diagram shows the resources that will be created by ECS-CF-springboot-ALB-single-service CloudFormation stack

<b>ResourcesToBeCreated-multiple-services:</b> This diagram shows the resources that will be created by ECS-CF-springboot-ALB-multiple-services CloudFormation stack

<b>Steps to build the microservice and launch the ECS Cluster</b>

<b>1. Build your applciation jar:</b> "gradle clean build" from root directory of the applications springbootservice1 & springbootservice2

<b>2. Build springbootservice1 Docker image : </b> "docker build -t springbootservice1 ." from root directory 

<b>2. Build springbootservice2 Docker image : </b> "docker build -t springbootservice2 ." from root directory

<b>3. Host the Docker image:</b> Host this docker image to Docker hub or ECR

<b>4. Launch ECS Cluster from CloudFormation: </b> Use ECS-CF-springboot-ALB-single-service to launch the cluster with springbootservice1 only and if you want to launch both the services then use ECS-CF-springboot-ALB-multiple-services
You can either save the YML files to an s3 bucket and refer during launching the CF stack or copy its content and paste in designer.

These template use image(s) hosted on AWS ECR, you can use your own image hosted on ECR or Docker hub. To do so, search for "image" in the template and replace it with your image.

When you will launch the CloudFormation stack, provide some values when asked like Cluster name, no of minum & maximum number of instances in ECS Cluster, VPC, Subnets.... 

<b>5. Test the service(s): </b> Wait untill Stack status is shown as Complete

Check in Load Balancers list under EC2 Service, you will see a newly created ALB with name ECSALB.
Access its DNS with as mentioned below, please use the DNS of your ALB and not the one shown below.

<Your ALB URL>/service1
You will see message "Welcome to the 3Pilar Global springboot service sample"

<Your ALB URL>/service1/hello
You will see message "Hello, how are you today..."

<Your ALB URL>/service2
You will see message "Welcome to the 3Pilar Global springboot service2 sample"

<Your ALB URL>/service2/hello
You will see message "Hello from service2..."

When you call your multiple services using single ALB as mentioned in above, it is called path based routing when the ALB determines that which Target Group wikk service a request like /service1 or /service2

Please check other resources created by CloudFormation.

<b>6. Delete the stack </b> Once done, go and check the box again CloudFormation Stack and from Actions choose Delete Stack, this will delete all the resources created by the Stack.