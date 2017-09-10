# OpenShift Getting Started

## create openshift cluster

1. install latest oc from https://github.com/openshift/origin/releases
2. docker is required
3. run this:

```bash
oc cluster up
...
Starting OpenShift using openshift/origin:v3.6.0 ...
OpenShift server started.

The server is accessible via web console at:
    https://127.0.0.1:8443

You are logged in as:
    User:     developer
    Password: <any value>

To login as administrator:
    oc login -u system:admin
```

## open console

```bash
open https://127.0.0.1:8443
```

## stop cluster

```bash
oc cluster down
```

## problem solving

### problem 1.1: if you have error like

```bash
-- Checking Docker daemon configuration ... FAIL
   Error: did not detect an --insecure-registry argument on the Docker daemon
   Solution:

     Ensure that the Docker daemon is running with the following argument:
     	--insecure-registry 172.30.0.0/16

     You can run this command with --create-machine to create a machine with the
     right argument.
```

### solution 1.1: then you can fix like so:

go to Docker -> Preferences... -> Daemon -> insecure registries -> add: 172.30.0.0/16 -> Apply & Restart

now you can use command:

```bash
oc cluster up
```

### solution 1.2: or use command:

```bash
oc cluster up --skip-registry-check=true

```

### problem 2: if you have and error such

```bash
-- Starting OpenShift container ... FAIL
   Error: exec: "socat": executable file not found in $PATH
[powerline-bash]  Your current directory is invalid. Lowest valid directory: /Users/mak/Documents/code/test/docker/openshift-examples
```

### solution 2: then install openshift client using brew (if you on mac):

```bash
brew install openshift-cli
...
```

read more:

- [openshift on github](https://github.com/openshift/origin)
