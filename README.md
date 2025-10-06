# 🏥 Appointment Parser API

A sophisticated natural language processing system that converts unstructured appointment requests into structured scheduling data. Built with Spring Boot and deployed to production.

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-green)
![Java](https://img.shields.io/badge/Java-17-blue)
![Status](https://img.shields.io/badge/Status-Production%20Ready-success)

## 🚀 Live Demo

**Live API:** [https://appointment-parser-production.up.railway.app](https://appointment-parser-production.up.railway.app)

**Frontend Interface:** [https://appointment-parser-production.up.railway.app](https://appointment-parser-production.up.railway.app)

## 📋 Features

### 🤖 Natural Language Processing
- **Smart Entity Extraction**: Identifies dates, times, and departments from natural language
- **20+ Pattern Recognition**: Handles various date/time formats and medical departments
- **Confidence Scoring**: Intelligent ambiguity detection with confidence metrics

### 🏗️ Architecture
- **Multi-Service Pipeline**: Clean separation of concerns with specialized services
- **RESTful API**: Professional API design with proper HTTP status codes
- **Production Ready**: Comprehensive error handling and validation

### 🛡️ Production Features
- **Guardrail System**: Detects ambiguous inputs and requests clarification
- **Health Monitoring**: Live health check endpoints
- **Professional Logging**: Structured logging for easy debugging

## 🎯 Quick Start

### Test the API:

```bash
# Health Check
curl https://appointment-parser-production.up.railway.app/api/v1/appointments/health

# Parse Appointment
curl -X POST https://appointment-parser-production.up.railway.app/api/v1/appointments/parse \
  -F "text=Book dentist next Friday at 3pm"
