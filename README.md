# Data-Structure
enum Role {
    manager = "Manager",
    developer = "Developer",
    intern = "Intern"
}

interface Employee {
    id: number;
    name: string;
    email: string;
    role: Role;
    status: "active" | "inactive";
}

const employees: Employee[] = [];

function addEmployee(emp: Employee): void {
    employees.push(emp);
}

function updateEmployee(id: number, update: Partial<Employee>): Employee | undefined {
    const employeeIndex = employees.findIndex(emp => emp.id === id);
    
    if (employeeIndex !== -1) {
        const updatedEmployee = { ...employees[employeeIndex], ...update };
        employees[employeeIndex] = updatedEmployee;
        return updatedEmployee;
    } else {
        console.log(`Employee with ID ${id} not found`);
        return undefined; 
    }
}

type EmployeeSummary = Pick<Employee, 'id' | 'name' | 'email' | 'role' | 'status'>;

function generateEmployeeSummary(employee: EmployeeSummary): string {
    return `ID: ${employee.id}, Name: ${employee.name}, Email: ${employee.email}, Role: ${employee.role}, Status: ${employee.status}`;
}

type EmployeeMap = Record<Role, Employee[]>;

function groupEmployeesByRole(employees: Employee[]): EmployeeMap {
    return employees.reduce((acc, emp) => {
        if (!acc[emp.role]) {
            acc[emp.role] = [];
        }
        acc[emp.role].push(emp);
        return acc;
    }, {} as EmployeeMap);
}

function isManager(emp: Employee): boolean {
    return emp.role === Role.manager;
}

function isActive(employee: Employee): boolean {
    return employee.status === "active";
}

interface LogData {
    id: number;
    task: string;
    date: string;
}

const logDataEmp: LogData[] = [];

function logActivity(data: LogData): void {
    const employee = employees.find(emp => emp.id === data.id);
    if (!employee) {
        console.error(`Employee with ID ${data.id} not found`);
        return;
    }

    if (!isActive(employee)) {
        console.error(`Inactive employee ${employee.name} cannot log activities`);
        return;
    }

    if (data.task === "approve loan" && !isManager(employee)) {
        console.error(`Only managers can approve loans`);
        return;
    }

    console.log(`Activity logged for ${employee.name}: ${data.task}`);
    logDataEmp.push(data);
}

addEmployee({ id: 1, name: "Alice", email: "alice@example.com", role: Role.manager, status: "active" });
addEmployee({ id: 2, name: "Bob", email: "bob@example.com", role: Role.developer, status: "inactive" });
addEmployee({ id: 3, name: "Jayesh", email: "jayesh@example.com", role: Role.developer, status: "active" });
addEmployee({ id: 4, name: "Kartik", email: "kartik@example.com", role: Role.developer, status: "inactive" });
addEmployee({ id: 5, name: "Shri", email: "shri@example.com", role: Role.intern, status: "active" });

logActivity({ id: 1, task: "approve loan", date: "23 jan" }); // Only managers can approve loans
logActivity({ id: 2, task: "submit report", date: "24 jan" });
logActivity({ id: 3, task: "review application", date: "25 jan" });
logActivity({ id: 4, task: "update records", date: "26 jan" });
logActivity({ id: 5, task: "attend meeting", date: "27 jan" });
logActivity({ id: 6, task: "prepare presentation", date: "28 jan" });

console.log(generateEmployeeSummary(employees[0]));
console.log(generateEmployeeSummary(employees[1]));
console.log(generateEmployeeSummary(employees[2]));
console.log(generateEmployeeSummary(employees[3]));
console.log(generateEmployeeSummary(employees[4]));

// Group employee role
console.log(groupEmployeesByRole(employees));

console.log(isManager(employees[1]));
console.log(isActive(employees[2]));

// Analytics Dashboard
function countTotalEmployees(): number {
    return employees.length;
}

function countActiveEmployees(): number {
    return employees.filter(isActive).length;
}

function displayTask(): void {
    console.table(logDataEmp);
}

function displayRoleDistribution(): void {
    const roleCount: { [key in Role]?: number } = {};
    employees.forEach(emp => {
        roleCount[emp.role] = (roleCount[emp.role] || 0) + 1;
    });
    console.log("Role Distribution:", roleCount);
}


//Dashboard
console.log("Total Employees:", countTotalEmployees());
console.log("Active Employees:", countActiveEmployees());
console.log("Task records:");
displayTask();
displayRoleDistribution();


function simulateError(){
    try {
        updateEmployee(7,{email:'xyz@gmail.com',role:Role.manager})
    }catch(error){
        console.error("Error updating employee:", error);
    }

    try {
        logActivity({ id: 8, task: "submit report", date: "24 jan" });
    } catch (error) {
        console.error("Error logging activity:", error);
    }
}

simulateError();

function displayEmployeeData(): void {
    console.group("Employee Data");
    console.table(employees);
    //employees.forEach(emp => console.table(emp));
    console.groupEnd();
}

displayEmployeeData();
