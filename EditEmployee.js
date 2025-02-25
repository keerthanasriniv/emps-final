import React,{useState,useEffect}from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import {useNavigate, useParams} from 'react-router-dom' 
import { Button } from '@mui/material';
import './AddEmployee.css'
import axios from 'axios';
export default function EditEmployee()
{
    const[formData,setFormData]=useState({
        emp_name:'',
        emp_dept:'',
        emp_job:'',
        emp_salary:'',
        emp_email:''
    })
    const { id } = useParams();
    console.log("Employee ID from URL:", id);
    useEffect(()=>{
        if(id){
        const fetchEmployee=async ()=>{
            try{
        const response=await axios.get(`http://localhost:8080/employee/${id}`);
        setFormData(response.data);
            }catch(error){
                console.error("Error fetching employee data:", error);
            }
        };
       
        fetchEmployee();
    }

},[id]);

    const handleSubmit=async (event)=>
    {
        event.preventDefault();
        if (!validateEmail(formData.emp_email)) {
            alert("Please enter a valid email address.");
            return;
        }

        try{
        const response=await axios.put(`http://localhost:8080/employee/${id}`,formData, {
        headers: {
            'Content-Type': 'application/json',
        },
        }
    );
        if (response.status === 200 || response.status === 201) {
            console.log("Navigation triggered after success.");
            navigate('/');
        } else {
            console.error("Unexpected response status:", response.status);
        }
        }
        // catch(error){console.log("Error while adding an employee",error)};  
        catch (error) {
          if (error.response) {
              // Server-side error
              console.error("Server responded with error:", error.response.data);
          } else if (error.request) {
              // No response received
              console.error("No response received:", error.request);
          } else {
              // Error during request setup
              console.error("Error in setting up the request:", error.message);
          }
      }
        
    }
    const handleChange=(event)=>{
        const{name,value}=event.target;
        setFormData((prevData)=>({
            ...prevData,[name]:value
        }));
    };
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

const validateEmail = (email) => {
    return emailRegex.test(email);
};
    const navigate=useNavigate();

       return(
                <>
                <div className='container'style={{marginTop:'20px',width:'50%'}}>
                <div className='row'>
                <div className='card'>
                <h2 className='text-center'>Edit Employee Details</h2>
                <div className='card-body'>
                            <form  class="form-group" onSubmit={handleSubmit}>
                            <div className='form-group mb-10'>
                            {/*<label htmlFor="employeeId">Employee ID:</label>
                      <input className='add-form'type="text"id="employeeId"name="employeeId"class="form-control"value={formData.emp_id}
                      onChange={handleChange} required/>
                      <br/>}*/}
                       <label htmlFor="name">Name:</label>
                        <input type="text"id="name"name="emp_name"class="form-control"value={formData.emp_name}
                      onChange={handleChange} required/> <br/>
        
                      </div>
        
                      <div className='form-group mv-2'>
                       <label htmlFor="department">Department:</label>
                        <input type="text"id="department"name="emp_dept"class="form-control"value={formData.emp_dept}
                      onChange={handleChange} required/> <br/>
        
                      </div>
        
                      <div className='form-group mv-2'>
                       <label htmlFor="designation">Designation:</label>
                        <input type="text"id="designation"name="emp_job"class="form-control"value={formData.emp_job}
                      onChange={handleChange} required/> <br/>
        
                      </div>
        
                      <div className='form-group mv-2'>
                       <label htmlFor="employeeId">Salary:</label>
                        <input type="text"id="salary"name="emp_salary"class="form-control"value={formData.emp_salary}
                      onChange={handleChange} required/> <br/>
        
                      </div>
        
                      <div className='form-group mv-2'>
                       <label htmlFor="email">Email:</label>
                        <input type="text"id="email"name="emp_email"class="form-control"value={formData.emp_email}
                      onChange={handleChange} required/>
        
                      </div>
        <br/>
                      <Button sx={{ marginRight: 2 }}type="submit"variant="contained" color="success">
          Submit
        </Button>
        <Button  sx={{ marginRight: 2 }}onClick={()=>navigate('/')} variant="outlined" color="error">
          Cancel
        </Button>
                      
                            </form>
                        </div>
                        </div>
                        </div>
                        </div>
        
        <br></br>
        
                </>
               );
}