FROM ubuntu:latest
LABEL authors="salih"

ENTRYPOINT ["top", "-b"]