<template>
  <div class="container my-5">
    <div class="row justify-content-center">
      <div class="col-8">
        <h2 class="d-flex">Customer</h2>
        <div class="d-flex justify-content-end">
          <button
            class="btn btn-primary btn-md rounded shadow mb-3"
            data-bs-toggle="modal"
            data-bs-target="#createModal"
            style="width: 170px"
            @click="addClick()" 
          >
            Add
          </button>
        </div>

        <div class="card rounded shadow">
          <div class="card-header">Customer List</div>
          <div class="card-body">
            <table class="table">
              <thead>
                <th scope="col">No.</th>
                <th scope="col">Nama</th>
                <th scope="col">Jabatan</th>
                <th scope="col">Gender</th>
                <th scope="col">Action</th>
              </thead>
              <tbody>
                <tr
                  v-for="(customer, index) in customers"
                  v-bind:key="customer.id"
                >
                  <td>{{ index + 1 }}</td>
                  <td>{{ customer.nama }}</td>
                  <td>{{ customer.jabatan }}</td>
                  <td>{{ customer.gender }}</td>
                  <td>
                    <div class="btn-group">
                      <div class="px-2">
                        <button
                          @click="editClick(customer)"
                          class="btn btn-sm btn-success"
                          data-bs-toggle="modal"
                          data-bs-target="#editModal"
                        >
                          Edit
                        </button>
                      </div>
                      <button
                        class="btn btn-sm btn-danger px-2"
                        data-bs-toggle="modal"
                        data-bs-target="#destroyModal"
                        @click="deleteClick(customer._id)"
                      >
                        Delete
                      </button>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Pop Up Modal Create data Customer-->
  <div
    class="modal fade"
    id="createModal"
    tabindex="-1"
    aria-labelledby="createModalLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title text-secondary" id="createModalLabel">
            Add Customer
          </h5>
        </div>
        <div class="modal-body">
          <form @submit.prevent="createCustomer">
            <div class="cols-12 d-flex">
              <label for="nama" class="form-label">Nama</label>
            </div>
            <input
              type="text"
              class="form-control"
              name="nama"
              v-model="nama"
              required
            />
            <div class="d-flex justify-content-between">
              <div class="field mt-3">
                <label for="jabatan" class="form-label d-flex">Jabatan</label>
                <div class="control">
                  <select v-model="jabatan">
                    <option disabled value="">Select one</option>
                    <option>Manager</option>
                    <option>Technical Lead</option>
                    <option>Backend Developer</option>
                    <option>Frontend Developer</option>
                  </select>
                </div>
              </div>

              <div class="field mt-3">
                <label for="gender" class="form-label d-flex">Gender</label>
                <div class="control">
                  <select v-model="gender">
                    <option style="height: 20px" disabled value="">
                      Select one
                    </option>
                    <option>Male</option>
                    <option>Female</option>
                  </select>
                </div>
              </div>
            </div>

            <div class="d-flex justify-content-end" style="margin-top: 20px">
              <div>
                <button
                  type="submit"
                  class="btn btn-primary mt-3 mr-2"
                  data-bs-dismiss="modal"
                >
                  Save
                </button>
              </div>
              <div style="margin-left: 10px">
                <button
                  type="button"
                  class="btn btn-warning mt-3 ml-2"
                  data-bs-dismiss="modal"
                >
                  Close
                </button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>

  <!-- Pop Up Modal edit Data Customer -->
  <div
    class="modal fade"
    id="editModal"
    tabindex="-1"
    aria-labelledby="editModalLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title text-secondary" id="editModalLabel">
            Edit Data Customer
          </h5>
        </div>
        <div class="modal-body">
          <form @submit.prevent="editCustomer">
            <div class="cols-12 d-flex">
              <label for="nama" class="form-label">Nama</label>
            </div>
            <input
              type="text"
              class="form-control"
              name="nama"
              v-model="nama"
              required
            />
            <div class="d-flex justify-content-between">
              <div class="field mt-3">
                <label for="jabatan" class="form-label d-flex">Jabatan</label>
                <div class="control">
                  <select v-model="jabatan">
                    <option disabled value="">Select one</option>
                    <option>Manager</option>
                    <option>Technical Lead</option>
                    <option>Backend Developer</option>
                    <option>Frontend Developer</option>
                  </select>
                </div>
              </div>

              <div class="field mt-3">
                <label for="gender" class="form-label d-flex">Gender</label>
                <div class="control">
                  <select v-model="gender">
                    <option style="height: 20px" disabled value="">
                      Select one
                    </option>
                    <option>Male</option>
                    <option>Female</option>
                  </select>
                </div>
              </div>
            </div>

            <div class="d-flex justify-content-end" style="margin-top: 20px">
              <div>
                <button
                  type="submit"
                  class="btn btn-primary mt-3 mr-2"
                  data-bs-dismiss="modal"
                >
                  Update Data
                </button>
              </div>
              <div style="margin-left: 10px">
                <button
                  type="button"
                  class="btn btn-warning mt-3 ml-2"
                  data-bs-dismiss="modal"
                >
                  Close
                </button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>

  <!-- Pop Up Modal Confirmation Delete Data Customer -->
<div id="destroyModal" class="modal fade">
	<div class="modal-dialog modal-confirm">
		<div class="modal-content">
			<div class="modal-header flex-column">
				<div class="icon-bs-box">
					<i class="material-bs-icons">&#xE5CD;</i>
				</div>						
				<h4 class="modal-title w-100">Are you sure?</h4>	
			</div>
			<div class="modal-body">
				<p>Do you really want to delete this data?</p>
			</div>
			<div class="modal-footer justify-content-center">
				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-danger" data-bs-dismiss="modal" @click="deleteData()">Delete</button>
			</div>
		</div>
	</div>
</div>    
</template>


<script>
import axios from "axios";

export default {
  name: "Customers",
  data() {
    return {
      customers: [],
      id: "",
      nama: "",
      jabatan: "",
      gender: "",
      genders: [
        { text: "Select Gender", value: null },
        { text: "Male", value: "Male" },
      ],
    };
  },
  methods: {
    //GetAll method from database 
    getCustomers() {
      axios
        .get("http://localhost:8080/api/customers/")
        .then((res) => {
          this.customers = res.data;
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    //Method to setup createModal or clear the field form
    addClick() {
      this.nama = "";
      this.jabatan = "";
      this.gender = "";
      this.id = "";
    },
    //Method to Save Data to Database via API
    createCustomer() {
      axios
        .post("http://localhost:8080/api/customers/", {
          nama: this.nama,
          jabatan: this.jabatan,
          gender: this.gender,
        })
        .then((res) => {
          // handle success
          this.getCustomers();
          this.nama = "";
          this.jabatan = "";
          this.gender = "";
          console.log(res);
        })
        .catch((err) => {
          // handle error
          console.log(err);
        });
    },
    //Method to setup editModal or fill in the form fields according to customer data._id
    editClick(customer) {
      this.nama = customer.nama;
      this.jabatan = customer.jabatan;
      this.gender = customer.gender;
      this.id = customer._id;
      console.log(customer);
    },
    //Method to Update/Edit Data via API
    editCustomer() {
      axios
        .put("http://localhost:8080/api/customer/" + this.id, {
          nama: this.nama,
          jabatan: this.jabatan,
          gender: this.gender,
        })
        .then(() => {
          this.getCustomers();
        });
    },
    //Method to setup destroyModal
    deleteClick(id) {
      this.id = id;
    },
    //Method delete Data from Database based on customer._id
    deleteData() {
      axios.delete("http://localhost:8080/api/customer/" + this.id).then(() => {
        this.getCustomers();
      });
    },
  },
  created() {
    this.getCustomers();
  },
};
</script>
